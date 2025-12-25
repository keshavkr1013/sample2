package LLDQuestions.MeetingScheduler.BookingStrategy;
import java.util.*;

import  LLDQuestions.MeetingScheduler.*;

public interface BookingStrategy {
    public Booking bookMeeting(Meeting meeting,  List<Room> rooms, Map<Room, List<Booking>> roomToBookings);
}
