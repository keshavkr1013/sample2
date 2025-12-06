package LLDQuestions.LibraryManagementSystem;

public class Librarian extends SystemUser{
    Search searchObj;
    BookIssueService issueService;
    public void addNewBook(BookItem bookItem)
    {
        searchObj.bookItems.add(bookItem);
    }
    public BookItem editBookItem(BookItem bookItem)
    {
        for (int i = 0; i < searchObj.bookItems.size(); i++) {
            if (searchObj.bookItems.get(i).barcode.equals(bookItem.barcode)) {
                searchObj.bookItems.set(i, bookItem);
                return bookItem;
            }
        }
        return null;
    }
    public BookItem deleteBookItem(String barcode)
    {
        return new BookItem();
    }
}
