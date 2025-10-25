package LLDQuestions.MyDesignATM.ATMStates;

import LLDQuestions.MyDesignATM.*;

public class SelectOperationState extends ATMState {
    public SelectOperationState()
    {
        showOperations();
        
    }

    @Override
    public void selectOperation(ATM atm, Card card, TransactionType txnType)
    {
        if(txnType == TransactionType.BALANCE_CHECK)
        {
            atm.setAtmState(new CheckBalanceState());
        }
        else
        {
            if(txnType == TransactionType.CASH_WITHDRAWAL)
            {
                atm.setAtmState(new CashWithdrawalState());
            }
            else{
                System.out.println("Invalid operation Selected");
                exit(atm);
            }
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

    public void showOperations()
    {
        System.out.println("Please select one of the operations");
        TransactionType.getAllTransactionTypes();
    }
}
