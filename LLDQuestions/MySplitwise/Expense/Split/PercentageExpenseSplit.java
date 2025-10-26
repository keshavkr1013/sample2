package LLDQuestions.MySplitwise.Expense.Split;

import java.util.*;
public class PercentageExpenseSplit implements ExpenseSplit{
    public void validateExpenseSplit(List<Split> splits, double totalAmount)
    {
        double calculatedPercentage = 0;
        for(Split split: splits)
        {
            calculatedPercentage += split.getPercentageOwe();
            split.setAmountOwe((totalAmount*split.getPercentageOwe())/100);
        }
        if(calculatedPercentage!=100)
        {
            throw new IllegalArgumentException("Sum of percentage owes across all splits is not equal to 100");
        }
    }
    
}
