package LLDQuestions.TaskScheduler;



public class Task {
    final String id;
    final Runnable action;
    final ExecutionType type;
    final long intervalMillis;
    long nextExecutionTime;
    boolean cancelled = false;

    public Task(String id, Runnable action, ExecutionType type, long intervalMillis, long nextExecutionTime)
    {
        this.id = id;
        this.action = action;
        this.type = type;
        this.intervalMillis = intervalMillis;
        this.nextExecutionTime = nextExecutionTime;
    }

}
