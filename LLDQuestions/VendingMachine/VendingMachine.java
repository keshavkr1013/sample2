package LLDQuestions.VendingMachine;
import java.util.*;
import LLDQuestions.VendingMachine.MachineStates.*;
public class VendingMachine {
    Inventory inventory;
    State state;
    List<Coin> coins = new ArrayList<>();
    public VendingMachine(Inventory inventory, State state, List<Coin> coins)
    {
        this.inventory = inventory;
        this.state = state;
        this.coins = coins;
    }
    public State getState()
    {
        return state;
    }
    public void setState(State state)
    {
        this.state = state;
    }
    public List<Coin> getCoins()
    {
        return coins;
    }
    public void setCoins(List<Coin> coins)
    {
        this.coins = coins;
    }
    public void addCoin(Coin coin)
    {
        coins.add(coin);
    }
    public void displayInventory(){
        for(ItemShelf itemShelf: inventory.itemShelves)
        {
            if(itemShelf.isAvailable)
            System.out.println("Item "+ itemShelf.item.itemType + " in code "+ itemShelf.code + " status: "+ itemShelf.isAvailable);
            else
            System.out.println("no item present in "+ itemShelf.code);
        }
    }
    public ItemShelf getItemShelf(int code)
    {
        for(ItemShelf itemShelf: inventory.itemShelves)
        {
            if(itemShelf.code == code)
            {
                return itemShelf;
            }
        }
        return null;
    }
}
