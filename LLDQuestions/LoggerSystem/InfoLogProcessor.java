package LLDQuestions.LoggerSystem;

public class InfoLogProcessor extends LogProcessor {
    InfoLogProcessor(LogProcessor nextLogProcessor)
    {
        super(nextLogProcessor);
    }
    public void log(String logType, String message)
    {
        if(logType.equals(LogProcessor.INFO))
        {
            System.out.println("Info "+ message);
        }
        else
        {
            super.log(logType, message);
        }
    }
}
