package LLDQuestions.MySplitwise.Expense.Split;

import LLDQuestions.MySplitwise.User.*;
public class Split {
    User user;
    double amountOwe;
    double percentageOwe;

    public Split(User user, double amountOwe, double percentageOwe)
    {
        this.user = user;
        this.amountOwe = amountOwe;
        this.percentageOwe = percentageOwe;
    }

    public User getUser()
    {
        return user;
    }
    public void setUser(User user)
    {
        this.user = user;
    }
    public double getAmountOwe()
    {
        return amountOwe;
    }
    public void setAmountOwe(double amountOwe)
    {
        this.amountOwe = amountOwe;
    }
    public double getPercentageOwe()
    {
        return percentageOwe;
    }
    public void setPercentageOwe(double percentageOwe)
    {
        this.percentageOwe = percentageOwe;
    }
}
