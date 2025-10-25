package LLDQuestions.MyDesignATM.ATMStates;

import LLDQuestions.MyDesignATM.*;

public class IdleState extends ATMState {
    @Override
    public void insertCard(ATM atm, Card card)
    {
        System.out.println("Card is Inserted");
        atm.setAtmState(new HasCardState());
    }
}
