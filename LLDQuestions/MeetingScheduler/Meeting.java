package LLDQuestions.MeetingScheduler;

import java.time.LocalDateTime;
import java.util.*;
public class Meeting {
    public LocalDateTime startTime;
    public LocalDateTime endTime;
    public List<User> users;
    public Meeting(LocalDateTime startTime, LocalDateTime endTime, List<User> users)
    {
        this.startTime = startTime;
        this.endTime = endTime;
        this.users = users;
    }
}
