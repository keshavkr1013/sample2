package LLDQuestions.MySplitwise.Expense;

import LLDQuestions.MySplitwise.Expense.Split.*;
import LLDQuestions.MySplitwise.*;
import LLDQuestions.MySplitwise.User.*;
import java.util.*;
public class ExpenseController {
    // List<Expense> expenses;
    BalanceSheetController balanceSheetController =  new BalanceSheetController();
    public Expense createExpense(int expenseId, String description, List<Split> splits, User paidBy, ExpenseSplitType expenseSplitType, double totalAmount)
    {
        ExpenseSplit expenseSplit = SplitFactory.getExpenseSplit(expenseSplitType);
        expenseSplit.validateExpenseSplit(splits, totalAmount);
        Expense expense = new Expense(expenseId, description, paidBy, splits, expenseSplitType, totalAmount);
        balanceSheetController.updateBalanceSheet(paidBy, splits, totalAmount);
        return expense;
       
    }
}
