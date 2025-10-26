package LLDQuestions.MySplitwise.Expense;

import LLDQuestions.MySplitwise.Expense.Split.*;
public class SplitFactory {
    public static ExpenseSplit getExpenseSplit(ExpenseSplitType expenseSplitType)
    {
        if(expenseSplitType == ExpenseSplitType.EQUAL)
        {
            return new EqualExpenseSplit();
        }
        else if(expenseSplitType == ExpenseSplitType.UNEQUAL)
        {
            return new UnequalExpenseSplit();
        }
        else
        {
            return new PercentageExpenseSplit();
        }
    }
}
