package LLDQuestions.VendingMachine;

public class Item {
    public ItemType itemType;
    public int price;
    public Item(ItemType itemType, int price)
    {
        this.itemType = itemType;
        this.price = price;
    }
}
