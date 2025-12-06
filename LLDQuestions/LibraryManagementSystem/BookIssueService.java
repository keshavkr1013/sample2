package LLDQuestions.LibraryManagementSystem;

import java.util.*;
public class BookIssueService {
    FineService fineService;
    Map<String, BookReservationDetail> reservations = new HashMap<>();
    Map<String, BookIssueDetail> booksIssued = new HashMap<>();
    public BookReservationDetail getReservationDetail(BookItem bookItem)
    {
        for(var entry: reservations.entrySet())
        {
            String barcode = entry.getKey();
            if(barcode.equals(bookItem.barcode))
            {
                return entry.getValue();
            }
        }
        return null;
    }
    public void updateReservationDetail(BookReservationDetail bookReservationDetail)
    {

    }
    public BookReservationDetail reserveBook(BookItem bookItem, SystemUser user) throws Exception
    {
        BookReservationDetail existingReservationDetail = getReservationDetail(bookItem);
        if(existingReservationDetail==null)
        {
            System.out.println("Successfully created reservation for "+ bookItem.barcode+ " with user "+ user.firstName);
            BookReservationDetail reservationDetail = new BookReservationDetail(bookItem, new Date(), user, ReservationStatus.SUCCESS);
            reservations.put(bookItem.barcode, reservationDetail);
            bookItem.bookStatus = BookStatus.RESERVED;
            return reservationDetail;
        }
        else
        {
            System.out.println("Failed to create reservation as reservation already exists for this user");
            throw new Exception("Failed to create reservation as reservation already exists for this user");
        }
    }
    public BookIssueDetail issueBook(BookItem bookItem, SystemUser user, Date dueDate) throws Exception
    {
        BookIssueDetail bookIssueDetail;
        for(var entry: booksIssued.entrySet())
        {
            String currBarcode = entry.getKey();
            BookIssueDetail currBookIssueDetail = entry.getValue();
            if (currBarcode.equals(bookItem.barcode))
            {
                if(!user.email.equals(currBookIssueDetail.user.email))
                {
                    System.out.println("Book item is already issue to a different user");
                    throw new Exception("Book item is already issue to a different user");
                }
                else
                {
                    currBookIssueDetail.dueDate = dueDate;
                    return currBookIssueDetail;
                }
            }
        }
        bookIssueDetail = new BookIssueDetail(bookItem, new Date(), user, dueDate);
        booksIssued.put(bookItem.barcode, bookIssueDetail);
        bookItem.bookStatus = BookStatus.ISSUED;
        return bookIssueDetail;

    }
    public BookIssueDetail renewBook(BookItem bookItem, SystemUser user)
    {
        return new BookIssueDetail(bookItem, null, user, null);
    }
    public void returnBook(BookItem bookItem, SystemUser user)
    {

    }
}
