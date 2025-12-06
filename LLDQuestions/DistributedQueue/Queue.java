package LLDQuestions.DistributedQueue;

import java.util.*;
public class Queue {
    String name;
    List<Partition> partitions = new ArrayList<>();
    Partition getPartition(String key)
    {
        return partitions.get(0);
    }

}
