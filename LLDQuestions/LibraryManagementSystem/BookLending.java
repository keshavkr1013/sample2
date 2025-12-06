package LLDQuestions.LibraryManagementSystem;

import java.util.*;
public class BookLending {
    BookItem bookItem;
    Date date;
    SystemUser user;
    BookLending(BookItem bookItem, Date date, SystemUser user)
    {
        this.bookItem = bookItem;
        this.date = date;
        this.user = user;
    }
}
