package LLDQuestions.LibraryManagementSystem;

import java.util.*;
public class BookReservationDetail extends BookLending {
    ReservationStatus reservationStatus;
    BookReservationDetail(BookItem bookItem, Date date, SystemUser user, ReservationStatus reservationStatus)
    {
        super(bookItem, date, user);
        this.reservationStatus = reservationStatus;
    }
}
