package LLDQuestions.LoggerSystem;

public abstract class LogProcessor {
    public static String INFO = "Info";
    public static String DEBUG = "Debug";
    public static String ERROR = "Error";

    LogProcessor nextLogProcessor;

    public LogProcessor(LogProcessor nextLogProcessor)
    {
        this.nextLogProcessor = nextLogProcessor;
    }
    public void log(String logType, String message)
    {
        if(nextLogProcessor!=null)
        {
            nextLogProcessor.log(logType, message);
        }
    }
}
