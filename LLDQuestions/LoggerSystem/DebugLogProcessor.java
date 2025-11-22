package LLDQuestions.LoggerSystem;

public class DebugLogProcessor extends LogProcessor {
    DebugLogProcessor(LogProcessor nextLogProcessor)
    {
        super(nextLogProcessor);
    }
    public void log(String logType, String message)
    {
        if(logType.equals(LogProcessor.DEBUG))
        {
            System.out.println("Debug "+ message);
        }
        else
        {
            super.log(logType, message);
        }
    }
}
