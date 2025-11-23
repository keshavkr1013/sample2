package LLDQuestions.VendingMachine.MachineStates;
import java.util.*;

import LLDQuestions.VendingMachine.*;
public class HasMoneyState implements State{
    public HasMoneyState()
    {
        System.out.println("Vending Machine is in Has Expense State now");
    }
    public void clickOnInsertCoinButton(VendingMachine machine) throws Exception
    {
        throw new Exception("not supported");
    }
    public void insertCoin(VendingMachine machine, Coin coin) throws Exception
    {
        machine.addCoin(coin);
    }
    public void clickOnSelectProductButton(VendingMachine machine) throws Exception
    {
        machine.setState(new SelectProductState());
    }
    public void getFullRefund(VendingMachine machine) throws Exception
    {
        machine.setCoins(new ArrayList<>());
        machine.setState(new IdleState());
    }
    public void selectProduct(VendingMachine machine, ItemShelf itemShelf) throws Exception
    {
        throw new Exception("not supported");
    }
}
