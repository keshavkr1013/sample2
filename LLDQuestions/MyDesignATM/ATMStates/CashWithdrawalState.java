package LLDQuestions.MyDesignATM.ATMStates;

import LLDQuestions.MyDesignATM.*;
import LLDQuestions.MyDesignATM.AmountWithdrawal.*;


public class CashWithdrawalState extends ATMState {
    public CashWithdrawalState()
    {
        System.out.println("Please enter Withdrawal Amount");
    }
    @Override
    public void cashWithdraw(ATM atm, Card card, int withDrawAmount){
        CashWithdrawProcessor cashWithdrawProcessor =  new TwoThousandWithdrawProcessor(new FiveHundredWithdrawProcessor(new OneHundredWithdrawProcessor(null)));
        if (withDrawAmount > card.getBankBalance())
        {
            System.out.println("Insufficient Balance");
            exit(atm);
            return;

        }
        if(withDrawAmount > atm.getAtmBalance())
        {
            System.out.println("ATM doesn't have requested amount");
            exit(atm);
            return;
        }
        cashWithdrawProcessor.withdrawCash(atm, withDrawAmount);
        card.deductBalance(withDrawAmount);
        System.out.println("Amount Successfully Withdrawn from ATM" + withDrawAmount);
        exit(atm);
    };

    @Override
    public void exit(ATM atm)
    {
        returnCard();
        atm.setAtmState(new IdleState());
    }

    @Override
    public void returnCard()
    {
        System.out.println("Please collect your card");
    }

}
