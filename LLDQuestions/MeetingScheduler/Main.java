package LLDQuestions.MeetingScheduler;

import java.time.LocalDateTime;
import java.util.*;

import LLDQuestions.MeetingScheduler.BookingStrategy.*;
public class Main {
    public static void main(String[] args) {
        Room room1 = new Room(1, 1);
        Room room2 = new Room(5, 2);
        Room room3 = new Room(10, 3);

        User user1 = new User("Ram", "ram@gmail.com", 1);
        User user2 = new User("Ram", "ram@gmail.com", 1);
        User user3 = new User("Ram", "ram@gmail.com", 1);
        User user4 = new User("Ram", "ram@gmail.com", 1);

        BookingStrategy bookingStrategy = new MinimumSpillageStrategy();
        BookingManager bookingManager = new BookingManager(List.of(room1, room2, room3), bookingStrategy);

        Meeting meet1 = new Meeting(LocalDateTime.of(2025, 1, 10, 10, 30, 0),
                                    LocalDateTime.of(2025, 1, 10, 11, 30, 0),
                                    List.of(user1, user2, user3, user4));
        
        Booking booking1  = bookingManager.bookMeeting(meet1);


        Meeting meet2 = new Meeting(LocalDateTime.of(2025, 1, 10, 10, 30, 0),
                                    LocalDateTime.of(2025, 1, 10, 11, 30, 0),
                                    List.of(user1, user2, user3, user4));
        Booking booking2  = bookingManager.bookMeeting(meet2);

        Meeting meet3 = new Meeting(LocalDateTime.of(2025, 1, 10, 10, 30, 0),
                                    LocalDateTime.of(2025, 1, 10, 11, 30, 0),
                                    List.of(user1, user2, user3, user4));
        Booking booking3  = bookingManager.bookMeeting(meet2);
    }
}
