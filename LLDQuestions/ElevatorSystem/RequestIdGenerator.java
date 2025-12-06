package LLDQuestions.ElevatorSystem;

public class RequestIdGenerator {
    public static int id=0;
    public static int nextId()
    {
        return id++;
    }
}
