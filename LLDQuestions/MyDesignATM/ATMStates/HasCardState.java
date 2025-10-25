package LLDQuestions.MyDesignATM.ATMStates;


import LLDQuestions.MyDesignATM.*;
public class HasCardState extends ATMState {

    public HasCardState()
    {
        System.out.println("Please Enter your pin");
    }

    @Override
    public void authenticatePin(ATM atm, Card card, int pin)
    {
        boolean isCorrectPINentered = card.isCorrectPINentered(pin);
        if(isCorrectPINentered)
        {
            System.out.println("Pin successfully authenticated");
            atm.setAtmState(new SelectOperationState());
        }
        else{
            System.out.println("Incorrect pin entered");
            exit(atm);
        }
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
