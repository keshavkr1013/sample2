package LLDQuestions.MyDesignATM.AmountWithdrawal;

import LLDQuestions.MyDesignATM.ATM;

public class OneHundredWithdrawProcessor extends CashWithdrawProcessor {
    public OneHundredWithdrawProcessor(CashWithdrawProcessor cashWithdrawProcessor)
    {
        super(cashWithdrawProcessor);
    }
    public void withdrawCash(ATM atm, int amount)
    {
        int noOfNotes = amount/100;
        int balance = amount%100;

        int noOfOneHundredNotes =  atm.getNoOfOneHundredNotes();
        if(noOfNotes < noOfOneHundredNotes)
        {
            atm.setAtmBalance(atm.getAtmBalance() - noOfNotes*100);
            atm.setNoOfOneHundredNotes(noOfOneHundredNotes - noOfNotes);
            super.withdrawCash(atm, balance);
            return;
        }

        atm.setAtmBalance(atm.getAtmBalance() - noOfOneHundredNotes*100);
        atm.setNoOfOneHundredNotes(0);
        super.withdrawCash(atm, amount - noOfOneHundredNotes*100);
    }
}
