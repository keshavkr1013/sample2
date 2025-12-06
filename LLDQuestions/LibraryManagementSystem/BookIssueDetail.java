package LLDQuestions.LibraryManagementSystem;
import java.util.*;

public class BookIssueDetail extends BookLending{
    Date dueDate;
    BookIssueDetail(BookItem bookItem, Date date, SystemUser user, Date dueDate)
    {
        super(bookItem, date, user);
        this.dueDate = dueDate;
    }
}

