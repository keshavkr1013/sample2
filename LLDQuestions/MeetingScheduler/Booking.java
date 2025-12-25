package LLDQuestions.MeetingScheduler;

public class Booking {
    Room room;
    public Meeting meet;
    int bookingId;
    public Booking(Room room, Meeting meet, int bookingId)
    {
        this.room = room;
        this.meet = meet;
        this.bookingId = bookingId;
    }
}
