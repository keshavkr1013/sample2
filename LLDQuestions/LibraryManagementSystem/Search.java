package LLDQuestions.LibraryManagementSystem;

import java.util.*;
public class Search {
    List<BookItem> bookItems = new ArrayList<>();
    public List<BookItem> getBookByTitle(String title)
    {
        List<BookItem> bookItems = new ArrayList<>();
        for(BookItem bookItem: bookItems)
        {
            if(bookItem.title == title)
            {
                bookItems.add(bookItem);
            }
        }
        return bookItems;
    }
}
