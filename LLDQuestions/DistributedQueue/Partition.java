package LLDQuestions.DistributedQueue;
import java.util.concurrent.locks.ReentrantLock;
import java.util.*;
class Partition {

    private PriorityQueue<StoredMessage> readyQueue;  // sorted by visibleAfter
    private Map<String, StoredMessage> inFlight;
    private ReentrantLock lock = new ReentrantLock();

    void enqueue(StoredMessage m) {
        lock.lock();
        try { readyQueue.add(m); }
        finally { lock.unlock(); }
    }

    List<StoredMessage> receive(int max, long visibilityTimeoutMs) {
        lock.lock();
        try {
            long now = System.currentTimeMillis();
            List<StoredMessage> result = new ArrayList<>();

            while(result.size() < max &&
                  !readyQueue.isEmpty() &&
                  readyQueue.peek().visibleAfter <= now) {

                StoredMessage sm = readyQueue.poll();
                sm.attempts++;
                sm.visibleAfter = now + visibilityTimeoutMs;
                inFlight.put(sm.id, sm);
                result.add(sm);
            }
            return result;
        }
        finally { lock.unlock(); }
    }

    boolean ack(String id) {
        lock.lock();
        try { return inFlight.remove(id) != null; }
        finally { lock.unlock(); }
    }

    void requeueExpired(long maxAttempts) {
        lock.lock();
        try {
            long now = System.currentTimeMillis();
            Iterator<StoredMessage> it = inFlight.values().iterator();

            while(it.hasNext()) {
                StoredMessage sm = it.next();
                if(sm.visibleAfter <= now) {
                    it.remove();
                    if(sm.attempts < maxAttempts)
                        readyQueue.add(sm);   // retry
                    // else → DLQ (optional)
                }
            }
        }
        finally { lock.unlock(); }
    }
}

