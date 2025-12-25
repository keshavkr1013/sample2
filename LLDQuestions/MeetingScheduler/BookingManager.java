package LLDQuestions.MeetingScheduler;

import java.util.*;
import  LLDQuestions.MeetingScheduler.BookingStrategy.*;
public class BookingManager {
    List<Room> rooms;
    List<Meeting> meetings;
    Map<Room, List<Booking>> roomToBookings;
    BookingStrategy bookingStrategy;
    BookingManager(List<Room> rooms, BookingStrategy bookingStrategy)
    {
        this.rooms = rooms;
        this.bookingStrategy = bookingStrategy;
        this.roomToBookings = new HashMap<>();
        this.meetings = new ArrayList<>();
    }

    public static boolean isOverlap(Meeting m1, Meeting m2)
    {
        if(m2.startTime.isBefore(m1.endTime) && m1.startTime.isBefore(m2.endTime))
            return true;
        return false;
    }

    public synchronized Booking bookMeeting(Meeting meeting)
    {
        Booking booking  = bookingStrategy.bookMeeting(meeting, rooms, roomToBookings);
        if(booking==null)
        {
            System.out.println("There is no room available for this meeting");
            return null;
        }
        else
        {
            System.out.println("Room: "+ booking.room.roomId+ " booked for this meeting");
        }
        Room roomBooked = booking.room;
        meetings.add(meeting);
        if(roomToBookings.get(roomBooked)==null)
        {
            roomToBookings.put(roomBooked, new ArrayList<>(List.of(booking)));
        }
        else
        {
            List<Booking> bookings = roomToBookings.get(roomBooked);
            bookings.add(booking);
            Collections.sort(bookings, (b1, b2) -> b1.meet.startTime.compareTo(b2.meet.startTime));
            roomToBookings.put(roomBooked, bookings);
        }
        return booking;
    }
}
