package LLDQuestions.MySplitwise.Expense;

import LLDQuestions.MySplitwise.User.*;
import LLDQuestions.MySplitwise.Expense.Split.*;

import java.util.*;
public class Expense {
    int expenseId;
    String description;
    User paidBy;
    List<Split> splits;
    ExpenseSplitType expenseSplitType;
    double totalAmount;
    public Expense(int expenseId, String description, User paidBy, List<Split> splits, ExpenseSplitType expenseSplitType, double totalAmount)
    {
        this.expenseId = expenseId;
        this.description = description;
        this.paidBy = paidBy;
        this.splits = splits;
        this.expenseSplitType = expenseSplitType;
        this.totalAmount = totalAmount;
    }
    public int getExpenseId()
    {
        return expenseId;
    }
    public void setExpenseid(int expenseid)
    {
        this.expenseId = expenseid;
    }
    public User getPaidBy()
    {
        return paidBy;
    } 
    public void setPaidBy(User paidBy)
    {
        this.paidBy = paidBy;
    }
}
