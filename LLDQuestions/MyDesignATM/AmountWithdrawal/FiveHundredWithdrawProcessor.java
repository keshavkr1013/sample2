package LLDQuestions.MyDesignATM.AmountWithdrawal;

import LLDQuestions.MyDesignATM.ATM;

public class FiveHundredWithdrawProcessor extends CashWithdrawProcessor{
    public FiveHundredWithdrawProcessor(CashWithdrawProcessor cashWithdrawProcessor)
    {
        super(cashWithdrawProcessor);
    }
    public void withdrawCash(ATM atm, int amount)
    {
        int noOfNotes = amount/500;
        int balance = amount%500;

        int noOfFiveHundredNotes =  atm.getNoOfFiveHundredNotes();
        if(noOfNotes < noOfFiveHundredNotes)
        {
            atm.setAtmBalance(atm.getAtmBalance() - noOfNotes*500);
            atm.setNoOfFiveHundredNotes(noOfFiveHundredNotes - noOfNotes);
            super.withdrawCash(atm, balance);
            return;
        }

        atm.setAtmBalance(atm.getAtmBalance() - noOfFiveHundredNotes*500);
        atm.setNoOfFiveHundredNotes(0);
        super.withdrawCash(atm, amount - noOfFiveHundredNotes*500);
    }   
}
