package LLDQuestions.MyBookMyShow;

import java.util.*;
public class Booking {
    int bookingId;
    Show show;
    List<Seat> bookedSeats = new ArrayList<>();
    Payment payment;
    public int getBookingId()
    {
        return bookingId;
    }
    public void setBookingid(int bookingId)
    {
        this.bookingId = bookingId;
    }
    public Show getShow()
    {
        return show;
    }
    public void setShow(Show show)
    {
        this.show = show;
    }
    public List<Seat> getBookedSeats()
    {
        return bookedSeats;
    }
    public void setBookedSeats(List<Seat> bookedSeats)
    {
        this.bookedSeats = bookedSeats;
    }
    public Payment getPayment()
    {
        return payment;
    }
    public void setPayment(Payment payment)
    {
        this.payment = payment;
    }

}
