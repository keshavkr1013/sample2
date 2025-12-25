package LLDQuestions.MeetingScheduler.BookingStrategy;


import java.util.*;

import  LLDQuestions.MeetingScheduler.*;
import java.time.*;

public class MinimumSpillageStrategy implements BookingStrategy{
    public Booking bookMeeting(Meeting meeting, List<Room> rooms, Map<Room, List<Booking>> roomToBookings)
    {
        Room bestRoom=null;
        long minSpillageMinutes = Integer.MAX_VALUE;
        for(Room room: rooms)
        {
            if(meeting.users.size()>room.capacity)
                continue;
            
            List<Booking> bookingsForRoom = roomToBookings.get(room);
            if (bookingsForRoom == null || bookingsForRoom.isEmpty()) {
                if (bestRoom == null) bestRoom = room;
                continue;
            }
            if(!meeting.endTime.isAfter(bookingsForRoom.get(0).meet.startTime))
            {
                Duration spillageDuration = Duration.between(meeting.endTime, bookingsForRoom.get(0).meet.startTime);
                long minutes = spillageDuration.toMinutes();
                if(minutes<minSpillageMinutes)
                {
                    bestRoom = room;
                    minSpillageMinutes = minutes;
                }
                continue;
            }
            if(!bookingsForRoom.get(bookingsForRoom.size()-1).meet.endTime.isAfter(meeting.startTime))
            {
                Duration spillageDuration = Duration.between(bookingsForRoom.get(bookingsForRoom.size()-1).meet.endTime, meeting.startTime);
                long minutes = spillageDuration.toMinutes();
                if(minutes<minSpillageMinutes)
                {
                    bestRoom = room;
                    minSpillageMinutes = minutes;
                }
                continue;
            }
            for(int i=0; i<bookingsForRoom.size()-1; i++)
            {
                Meeting currMeeting = bookingsForRoom.get(i).meet;
                Meeting nexMeeting = bookingsForRoom.get(i+1).meet;
                if(!currMeeting.endTime.isAfter(meeting.startTime) && !meeting.endTime.isAfter(nexMeeting.startTime))
                {
                    Duration availDuration = Duration.between(currMeeting.endTime, nexMeeting.startTime);
                    Duration meetDuration = Duration.between(meeting.startTime, meeting.endTime);
                    long minutes = availDuration.toMinutes() - meetDuration.toMinutes();
                    if(minutes<minSpillageMinutes)
                    {
                        bestRoom = room;
                        minSpillageMinutes = minutes;
                    }
                    break;
                }
            }
        }
        if(bestRoom!=null)
        {
            return new Booking(bestRoom, meeting, BookingIdGenerator.getNextId());
        }
        return null;
    }
}


