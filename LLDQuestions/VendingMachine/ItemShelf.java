package LLDQuestions.VendingMachine;

public class ItemShelf {
    public Item item;
    public int code;
    public boolean isAvailable = false;
    public ItemShelf(Item item, int code, boolean isAvailable)
    {
        this.item = item;
        this.code = code;
        this.isAvailable = isAvailable;
    }
    
}
