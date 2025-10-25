package LLDQuestions.MyDesignATM.ATMStates;

import LLDQuestions.MyDesignATM.ATM;
import LLDQuestions.MyDesignATM.Card;
import LLDQuestions.MyDesignATM.TransactionType;

public abstract class ATMState {

    public void cashWithdraw(ATM atm, Card card, int withDrawAmount ){
        System.out.println("OOPS! Something Wen Wrong.");
    };
    public void insertCard(ATM atm, Card card){
        System.out.println("OOPS! Something Went Wrong.");
    };

    public void displayBalance(ATM atm, Card card){
        System.out.println("OOPS! Something Went Wrong.");
    }

    public void returnCard( ){
        System.out.println("OOPS! Something Went Wrong.");
    }
    public void exit(ATM atm)
    {
        System.out.println("OOPS! Something Went Wrong.");
    }
    // public void enterPin(){

    // };
    public void authenticatePin(ATM atm, Card card, int pin)
    {
        System.out.println("OOPS! Something Went Wrong.");
    }

    public void selectOperation(ATM atm, Card card, TransactionType txnType)
    {
        System.out.println("OOPS! Something Went Wrong.");
    }

    
}
