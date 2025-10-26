package LLDQuestions.MySplitwise.User;


import LLDQuestions.MySplitwise.*;
public class User {
    int userId;
    String userName;
    UserExpenseBalanceSheet userExpenseBalanceSheet = new UserExpenseBalanceSheet();
    public int getUserId()
    {
        return userId;
    }
    public void setUserId(int userId)
    {
        this.userId = userId;
    }
    public String getUserName()
    {
        return userName;
    }
    public void setUserName(String userName)
    {
        this.userName = userName;
    }
    public UserExpenseBalanceSheet getUserExpenseBalanceSheet()
    {
        return userExpenseBalanceSheet;
    }
    public void setUserExpenseBalanceSheet(UserExpenseBalanceSheet userExpenseBalanceSheet)
    {
        this.userExpenseBalanceSheet = userExpenseBalanceSheet;
    }

}
