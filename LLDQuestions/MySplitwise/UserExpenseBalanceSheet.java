package LLDQuestions.MySplitwise;

import LLDQuestions.MySplitwise.User.*;
import java.util.*;

public class UserExpenseBalanceSheet {
    Map<User, Balance> userVsBalance;
    double totalYourExpense;
    double totalPayment;
    double totalYouOwe;
    double totalYouGetBack;

    public UserExpenseBalanceSheet()
    {
        userVsBalance = new HashMap<>();
        totalPayment = 0;
        totalYourExpense = 0;
        totalYouOwe = 0;
        totalYouGetBack = 0;
    }

    public Map<User, Balance> getUserVsBalance()
    {
        return userVsBalance;
    }
    public void setUserVsBalance(Map<User, Balance> userVsBalance)
    {
        this.userVsBalance = userVsBalance;
    }
    public double getTotalYourExpense()
    {
        return totalYourExpense;
    }
    public void setTotalYourExpense(double totalYourExpense)
    {
        this.totalYourExpense = totalYourExpense;
    }
    public double getTotalPayment()
    {
        return totalPayment;
    }
    public void setTotalPayment(double totalPayment)
    {
        this.totalPayment = totalPayment;
    }
    public double getTotalYouOwe()
    {
        return totalYouOwe;
    }
    public void setTotalYouOwe(double totalYouOwe)
    {
        this.totalYouOwe = totalYouOwe;
    }
    public double getTotalYouGetBack()
    {
        return totalYouGetBack;
    }
    public void setTotalYouGetBack(double totalYouGetBack)
    {
        this.totalYouGetBack = totalYouGetBack;
    }

}
