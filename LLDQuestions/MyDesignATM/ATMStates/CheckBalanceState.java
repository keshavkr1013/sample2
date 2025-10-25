package LLDQuestions.MyDesignATM.ATMStates;

import LLDQuestions.MyDesignATM.ATM;
import LLDQuestions.MyDesignATM.Card;

public class CheckBalanceState extends ATMState {
    @Override
    public void displayBalance(ATM atm, Card card){
        System.out.println("Total Balance in the account is"+ card.getBankBalance());
        exit(atm);
    }

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
