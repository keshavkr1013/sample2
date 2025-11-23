package LLDQuestions.VendingMachine.MachineStates;
import LLDQuestions.VendingMachine.*;
public interface State {
    public void clickOnInsertCoinButton(VendingMachine machine) throws Exception;
    public void insertCoin(VendingMachine machine, Coin coin) throws Exception;
    public void clickOnSelectProductButton(VendingMachine machine) throws Exception;
    public void getFullRefund(VendingMachine machine) throws Exception;
    public void selectProduct(VendingMachine machine, ItemShelf itemShelf) throws Exception;
    
}
