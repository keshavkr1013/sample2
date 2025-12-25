package LLDQuestions.MeetingScheduler;

public class BookingIdGenerator {
    public static int id=0;
    public static int getNextId()
    {
        id++;
        return id;
    }
}
