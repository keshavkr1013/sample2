package LLDQuestions.VendingMachine.MachineStates;

import LLDQuestions.VendingMachine.*;
public class DispenseState implements State {
    public DispenseState(VendingMachine machine)
    {
        System.out.println("Item successfully dispensed from vending Machine");
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
        throw new Exception("not supported");
    }
    public void selectProduct(VendingMachine machine, ItemShelf itemShelf) throws Exception
    {
        throw new Exception("not supported");
    }
}
