package LLDQuestions.TaskScheduler;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;
public class TaskScheduler {
    PriorityQueue<Task> pq = new PriorityQueue<>((a, b) -> Long.compare(a.nextExecutionTime, b.nextExecutionTime));

    ReentrantLock lock = new ReentrantLock();
    Map<String, Task> taskMap = new HashMap<>();
    
    Condition newTaskArrived = lock.newCondition();

    ExecutorService executor;
    Thread schedulerThread;

    public TaskScheduler(int numThreads)
    {
        executor = Executors.newFixedThreadPool(numThreads);
        schedulerThread = new Thread(this::runLoop);
        schedulerThread.setDaemon(true);
        schedulerThread.start();
    }

    public void schedule(Task task)
    {
        lock.lock();
        try{
            pq.add(task);
            taskMap.put(task.id, task);
            newTaskArrived.signal();
        } finally {
            lock.unlock();
        }
    }
    public void cancel(String taskId)
    {
        lock.lock();
        try{
            Task task = taskMap.get(taskId);
            if(task!=null)
            {
                taskMap.remove(taskId);
                task.cancelled = true;
            }
        } finally {
            lock.unlock();
        }
    }

    public void shutdown()
    {
        executor.shutdown();
        schedulerThread.interrupt();
    }
    public void runLoop()
    {
        while(true)
        {
            lock.lock();
            try {
                while(pq.isEmpty())
                {
                    newTaskArrived.await();
                }
                long now = System.currentTimeMillis();
                Task task = pq.peek();
                if(task.nextExecutionTime > now)
                {
                    long waitTime = task.nextExecutionTime-now;
                    newTaskArrived.awaitNanos(waitTime*1000000);
                    continue;
                }
                pq.poll();
                if(task.cancelled)
                    continue;

                executor.submit(task.action);
                String taskId = task.id;
                if(task.type == ExecutionType.RECURRING)
                {
                    task.nextExecutionTime+=task.intervalMillis;
                    pq.add(task);
                }
                else
                {
                    taskMap.remove(taskId);
                }

            } catch(InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
            finally {
                lock.unlock();
            }
           
        }
    }
}
