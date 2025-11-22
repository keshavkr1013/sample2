package LLDQuestions.LoggerSystem;

public class ErrorLogProcessor extends LogProcessor {
    ErrorLogProcessor(LogProcessor nextLogProcessor)
    {
        super(nextLogProcessor);
    }
    public void log(String logType, String message)
    {
        if(logType.equals(LogProcessor.ERROR))
        {
            System.out.println("Error "+ message);
        }
        else
        {
            super.log(logType, message);
        }
    }
}
