package LLDQuestions.MyBookMyShow;

import java.util.*;
public class Show {
    Movie movie;
    List<Seat> bookedSeats = new ArrayList<>();
    int startTime;
    Screen screen;
    public Movie getMovie()
    {
        return movie;
    }
    public void setMovie(Movie movie)
    {
        this.movie = movie;
    }
    public List<Seat> getBookedSeats()
    {
        return bookedSeats;
    }
    public void setBookedSeats(List<Seat> bookedSeats)
    {
        this.bookedSeats = bookedSeats;
    }
    public int getStartTime()
    {
        return startTime;
    }
    public void setStartTime(int startTime)
    {
        this.startTime = startTime;
    }
    public Screen getScreen()
    {
        return screen;
    }
    public void setScreen(Screen screen)
    {
        this.screen = screen;
    }
}
