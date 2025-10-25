package LLDQuestions.MyDesignATM;

import LLDQuestions.MyDesignATM.ATMStates.*;

public class ATM {
    public static ATM atmObject = new ATM(); //Singleton Design Pattern(private constructor)

    ATMState currentAtmState;
    int atmBalance;
    int noOfTwoThousandNotes;
    int noOfFiveHundredNotes;
    int noOfOneHundredNotes;

    private ATM()
    {

    }

    public void setAtmState(ATMState atmState)
    {
        this.currentAtmState = atmState;
    }

    public ATMState getAtmState()
    {
        return currentAtmState;
    }
    public static ATM getATMobj()
    {
        atmObject.setAtmState(new IdleState());
        return atmObject;
    }
    public int getAtmBalance()
    {
        return atmBalance;
    }

    public void setAtmBalance(int atmBalance)
    {
        this.atmBalance = atmBalance;
    }

    public int getNoOfTwoThousandNotes()
    {
        return noOfTwoThousandNotes;
    }
    public void setNoOfTwoThousandNotes(int noOfTwoThousandNotes)
    {
        this.noOfTwoThousandNotes = noOfTwoThousandNotes;
    }

    public int getNoOfFiveHundredNotes()
    {
        return noOfFiveHundredNotes;
    }
    public void setNoOfFiveHundredNotes(int noOfFiveHundredNotes)
    {
        this.noOfFiveHundredNotes = noOfFiveHundredNotes;
    }

    public int getNoOfOneHundredNotes()
    {
        return noOfOneHundredNotes;
    }
    public void setNoOfOneHundredNotes(int noOfOneHundredNotes)
    {
        this.noOfOneHundredNotes = noOfOneHundredNotes;
    }

    public void setAtmBalance(int atmBalance, int noOfTwoThousandNotes, int noOfFiveHundredNotes, int noOfOneHundredNotes)
    {
        this.atmBalance = atmBalance;
        this.noOfTwoThousandNotes = noOfTwoThousandNotes;
        this.noOfFiveHundredNotes = noOfFiveHundredNotes;
        this.noOfOneHundredNotes = noOfOneHundredNotes;
    }
    public void printCurrentATMStatus()
    {
        System.out.println("Balance: "+ atmBalance);
        System.out.println("No of 2000 notes: "+ noOfTwoThousandNotes);
        System.out.println("No of 500 notes: "+ noOfFiveHundredNotes);
        System.out.println("No of 100 notes: "+ noOfOneHundredNotes);
    }
}
