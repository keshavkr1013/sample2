package LLDQuestions.MeetingScheduler.BookingStrategy;


import java.util.*;

import  LLDQuestions.MeetingScheduler.*;


public class FirstRoomAvailable implements BookingStrategy{
    public Booking bookMeeting(Meeting meeting, List<Room> rooms, Map<Room, List<Booking>> roomToBookings)
    {
        for(Room room: rooms)
        {
            if(meeting.users.size()>room.capacity)
                continue;
            if(roomToBookings.get(room)==null)
            {
                return new Booking(room, meeting, BookingIdGenerator.getNextId());
            }
            else
            {
                List<Booking> bookingsForRoom = roomToBookings.get(room);
                boolean isOverlap = false;
                for(Booking booking: bookingsForRoom)
                {
                    Meeting currMeeting = booking.meet;
                    isOverlap = BookingManager.isOverlap(currMeeting, meeting);
                    if(isOverlap)
                        break;
                }
                if(!isOverlap)
                    return new Booking(room, meeting, BookingIdGenerator.getNextId());
            }
        }
        return null;
    }
}
