package LLDQuestions.DistributedQueue;

import java.util.*;
public class QueueService {
    Map<String, Queue> queues;
    String send(String queueName, String payload)
    {
        return "Send message";
    }
    List<Message> receive(String queueName, int maxMessages)
    {
        return new ArrayList<>();
    }
    boolean ack(String queueName, String messageId)
    {
        return true;
    }
}
