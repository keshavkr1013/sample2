package LLDQuestions.LoggerSystem;

public class Main {
    public static void main(String[] args) {
        LogProcessor logger = new InfoLogProcessor(new DebugLogProcessor(new ErrorLogProcessor(null)));
        logger.log(LogProcessor.INFO, "this is an information");
        logger.log(LogProcessor.DEBUG, "this is a debug message");
        logger.log(LogProcessor.ERROR, "this is an error message");

    }
    
}
