package LLDQuestions.MyBookMyShow;

import java.util.ArrayList;
import java.util.*;

import LLDQuestions.MyBookMyShow.enums.City;
import LLDQuestions.MyBookMyShow.enums.SeatCategory;



public class BookMyShow {
    MovieController movieController;
    TheatreController theatreController;

    BookMyShow()
    {
        movieController = new MovieController();
        theatreController = new TheatreController();
    }
    public static void main(String[] args) {
        BookMyShow bookMyShow = new BookMyShow();
        bookMyShow.initialize();
        bookMyShow.bookShow(City.BANGALORE, "F1", 4);
        bookMyShow.bookShow(City.BANGALORE, "F1", 4);
        bookMyShow.bookShow(City.DELHI, "F1", 4);
        bookMyShow.bookShow(City.DELHI, "F1", 4);
        bookMyShow.bookShow(City.BANGALORE, "RAID 2", 4);
        bookMyShow.bookShow(City.BANGALORE, "RAID 3", 4);
    }
    void initialize()
    {
        addMovies();
        addTheatres(City.BANGALORE);
        addTheatres(City.DELHI);
        
    }

    void bookShow(City city, String movieName, int startTime)
    {
        Movie movie = movieController.getMovieByName(movieName);
        if(movie==null)
        {
            System.out.println("No Movie found with movieName: " + movieName);
            return;
        }
        Map<Theatre, List<Show>> theatreVsShows = theatreController.getAllShows(city, movie);
        if(theatreVsShows==null)
        {
            System.out.println("No shows found for movieName: "+ movieName + " and city: " + city);
            return;
        }
        for(var entry: theatreVsShows.entrySet())
        {
            List<Show> shows = entry.getValue();
            for(Show show: shows)
            {
                if(show.getStartTime()!=startTime)
                    continue;
                int seatNumber=38;
                List<Seat> bookedSeats = show.getBookedSeats();
                for(Seat seat: show.getScreen().getSeats())
                {
                    if(seat.getSeatId()==seatNumber)
                    {
                        if(bookedSeats.contains(seat))
                        {
                            System.out.println("Seat no 38 is already Booked");
                            return;
                        }
                        else
                        {
                            bookedSeats.add(seat);
                            System.out.println("Seat no 38 successfully booked");
                            Booking booking = new Booking();
                            booking.setBookingid(123);
                            booking.setShow(show);
                            List<Seat> bookedSeatsBooking = new ArrayList<>();
                            bookedSeatsBooking.add(seat);
                            booking.setBookedSeats(bookedSeatsBooking);
                            Payment payment = new Payment();
                            payment.setPaymentId(345);
                            booking.setPayment(payment);
                            return;
                        }
                    }
                }
            }
        }
    }


    void addMovies()
    {
        Movie movie1 = new Movie();
        movie1.setMovieId(1);
        movie1.setMovieName("RAID 2");
        movie1.setMovieDuration(120);
        

        Movie movie2 = new Movie();
        movie2.setMovieId(2);
        movie2.setMovieName("F1");
        movie2.setMovieDuration(150);

        movieController.addMovie(movie1, City.KOLKATA);
        movieController.addMovie(movie1, City.BANGALORE);

        movieController.addMovie(movie2, City.KOLKATA);
        movieController.addMovie(movie2, City.BANGALORE);
    }

    Screen createScreen(int screenId)
    {
        Screen screen = new Screen();
        screen.setScreenId(screenId);

        List<Seat> seats = new ArrayList<>();
        
        //Row 1 to 10 SILVER seats
        for(int row=1;row<=10;row++)
        {
            for(int j=1;j<=10;j++)
            {
                Seat seat = new Seat();
                seat.setSeatId(row*10+j);
                seat.setRow(row);
                seat.setSeatCategory(SeatCategory.SILVER);
                seats.add(seat);
            }
        }

        //Row 11 to 20 SILVER seats
        for(int row=11;row<=20;row++)
        {
            for(int j=1;j<=10;j++)
            {
                Seat seat = new Seat();
                seat.setSeatId(row*10+j);
                seat.setRow(row);
                seat.setSeatCategory(SeatCategory.GOLD);
                seats.add(seat);
            }
        }

        //Row 21 to 30 PLATINUM seats
        for(int row=21;row<=30;row++)
        {
            for(int j=1;j<=10;j++)
            {
                Seat seat = new Seat();
                seat.setSeatId(row*10+j);
                seat.setRow(row);
                seat.setSeatCategory(SeatCategory.PLATINUM);
                seats.add(seat);
            }
        }
        screen.setSeats(seats);
        return screen;
    }

    void addTheatres(City city)
    {
        Theatre theatre1 = new Theatre();
        List<Screen> screens = new ArrayList<>();
        Screen screen1 = createScreen(1);
        Screen screen2 = createScreen(2);
        screens.add(screen1);
        screens.add(screen2);
        
        Movie movie1 = movieController.getMovieByName("F1");
        Movie movie2 = movieController.getMovieByName("RAID 2");

        List<Show> shows = new ArrayList<>();
        Show show1 = new Show();
        show1.setMovie(movie1);
        show1.setStartTime(4);
        show1.setScreen(screen1);
        shows.add(show1);

        Show show2 = new Show();
        show2.setMovie(movie2);
        show2.setStartTime(4);
        show2.setScreen(screen2);
        shows.add(show2);

        theatre1.setCity(city);
        if(city==City.BANGALORE)
        {
            theatre1.setAddress("Indiranagar");
        }
        else
        {
            theatre1.setAddress("Rajeev Chowk");
        }
        theatre1.setShows(shows);
        theatre1.setScreens(screens);
        theatreController.addTheatre(city, theatre1);
    }

}
