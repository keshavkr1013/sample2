package LLDQuestions.VendingMachine.MachineStates;
import LLDQuestions.VendingMachine.*;
public class IdleState implements State{
    public IdleState()
    {
        System.out.println("Vending Machine is in Idle State now");
    }
    public void clickOnInsertCoinButton(VendingMachine machine) throws Exception
    {
        machine.setState(new HasMoneyState());
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
        throw new Exception("not supported");
    }
    public void selectProduct(VendingMachine machine, ItemShelf itemShelf) throws Exception
    {
        throw new Exception("not supported");
    }
}
