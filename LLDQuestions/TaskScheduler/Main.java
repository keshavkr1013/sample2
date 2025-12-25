package LLDQuestions.TaskScheduler;


public class Main {
    public static void main(String[] args) throws Exception{
        long now = System.currentTimeMillis();
        Task task1 = new Task("1",
                            ()-> System.out.println("completed task 1"),
                            ExecutionType.RECURRING,
                            2000,
                            now + 1000);
        Task task2 = new Task("2",
                            ()-> System.out.println("completed task 2"),
                            ExecutionType.ONCE,
                            0,
                            now + 2000);
        TaskScheduler taskScheduler = new TaskScheduler(3);
        taskScheduler.schedule(task1);
        taskScheduler.schedule(task2);

        Thread.sleep(10000);

        taskScheduler.cancel("1");

        taskScheduler.shutdown();
        
    }
}
