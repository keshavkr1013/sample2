package LLDQuestions.MyDesignATM.AmountWithdrawal;

import LLDQuestions.MyDesignATM.ATM;
public class TwoThousandWithdrawProcessor extends CashWithdrawProcessor {
    public TwoThousandWithdrawProcessor(CashWithdrawProcessor cashWithdrawProcessor)
    {
        super(cashWithdrawProcessor);
    }
    public void withdrawCash(ATM atm, int amount)
    {
        int noOfNotes = amount/2000;
        int balance = amount%2000;

        int noOfTwoThousandNotes =  atm.getNoOfTwoThousandNotes();
        if(noOfNotes < noOfTwoThousandNotes)
        {
            atm.setAtmBalance(atm.getAtmBalance() - noOfNotes*2000);
            atm.setNoOfTwoThousandNotes(noOfTwoThousandNotes - noOfNotes);
            super.withdrawCash(atm, balance);
            return;
        }

        atm.setAtmBalance(atm.getAtmBalance() - noOfTwoThousandNotes*2000);
        atm.setNoOfTwoThousandNotes(0);
        super.withdrawCash(atm, amount - noOfTwoThousandNotes*2000);
    }   
}
