package LLDQuestions.MyDesignATM.AmountWithdrawal;

import LLDQuestions.MyDesignATM.*;
public abstract class CashWithdrawProcessor {
    CashWithdrawProcessor nextCashWithdrawProcessor;
    public CashWithdrawProcessor(CashWithdrawProcessor cashWithdrawProcessor)
    {
        nextCashWithdrawProcessor = cashWithdrawProcessor;
    }
    public void withdrawCash(ATM atm, int amount)
    {
        if(nextCashWithdrawProcessor != null)
        {
            nextCashWithdrawProcessor.withdrawCash(atm, amount);
        }
    }
}
