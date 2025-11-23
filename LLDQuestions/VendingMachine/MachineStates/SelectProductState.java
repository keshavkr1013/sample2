package LLDQuestions.VendingMachine.MachineStates;
import java.util.ArrayList;

import LLDQuestions.VendingMachine.*;
public class SelectProductState implements State{
    public SelectProductState()
    {
        System.out.println("Vending Machine is in Select State now");
    }
    public void clickOnInsertCoinButton(VendingMachine machine) throws Exception
    {
        throw new Exception("not supported");
    }
    public void insertCoin(VendingMachine machine, Coin coin) throws Exception
    {
        throw new Exception("not supported");
    }
    public void clickOnSelectProductButton(VendingMachine machine) throws Exception
    {
        throw new Exception("not supported");
    }
    public void getFullRefund(VendingMachine machine) throws Exception
    {
        System.out.println("full money refunded");
        machine.setCoins(new ArrayList<>());
        machine.setState(new IdleState());
    }
    public void selectProduct(VendingMachine machine, ItemShelf itemShelf) throws Exception
    {
        if(!itemShelf.isAvailable || (itemShelf.item==null))
        {
            throw new Exception("itemshelf is empty, please enter code for a available shelf");
        }
        int totalPaid = 0;
        for(Coin coin: machine.getCoins())
        {
            totalPaid+=coin.value;
        }
        int itemCost = itemShelf.item.price;
        if(totalPaid<itemCost)
        {
            System.out.println("Insuffient coins entered, initiating full refund");
            getFullRefund(machine);
            throw new Exception("insufficient coins entered");
        }
        int balance = (totalPaid-itemCost);
        if(balance>0)
        {
            System.out.println("Returned remanining change of Rs: "+ balance);
        }
        machine.setCoins(new ArrayList<>());
        itemShelf.isAvailable = false;
        itemShelf.item = null;
        machine.setState(new DispenseState(machine));
        machine.setState(new IdleState());
    }
}
