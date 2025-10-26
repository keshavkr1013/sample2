package LLDQuestions.MySplitwise.Expense.Split;

import java.util.List;

public class UnequalExpenseSplit implements ExpenseSplit{

    public void validateExpenseSplit(List<Split> splits, double totalAmount)
    {
        double calculatedTotal=0;
        for(Split split: splits)
        {
            calculatedTotal+=split.getAmountOwe();
        }
        if(calculatedTotal!=totalAmount)
        {
            throw new IllegalArgumentException("Unequal splits don't match total expense amount");
        }
    }
}
