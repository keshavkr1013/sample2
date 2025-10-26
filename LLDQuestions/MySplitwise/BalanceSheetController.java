package LLDQuestions.MySplitwise;


import LLDQuestions.MySplitwise.User.*;
import LLDQuestions.MySplitwise.Expense.Split.*;
import java.util.*;
public class BalanceSheetController {
    public void updateBalanceSheet(User paidBy, List<Split> splits, double totalAmount)
    {
        UserExpenseBalanceSheet paidByUserExpenseBalanceSheet = paidBy.getUserExpenseBalanceSheet();
        paidByUserExpenseBalanceSheet.setTotalPayment(paidByUserExpenseBalanceSheet.getTotalPayment() + totalAmount);
        for(Split split: splits)
        {
            User user = split.getUser();
            UserExpenseBalanceSheet userExpenseBalanceSheet = user.getUserExpenseBalanceSheet();
            if(user.getUserId() == paidBy.getUserId())
            {
                userExpenseBalanceSheet.setTotalYourExpense(userExpenseBalanceSheet.getTotalYourExpense() + split.getAmountOwe());
            }
            else
            {
                paidByUserExpenseBalanceSheet.setTotalYouGetBack(paidByUserExpenseBalanceSheet.getTotalYouGetBack() + split.getAmountOwe());
                userExpenseBalanceSheet.setTotalYourExpense(userExpenseBalanceSheet.getTotalYourExpense() + split.getAmountOwe());
                userExpenseBalanceSheet.setTotalYouOwe(userExpenseBalanceSheet.getTotalYouOwe() + split.getAmountOwe());

                //check if Owe user is present in paidBy balance sheet
                Map<User, Balance> paidByuserVsBalance = paidByUserExpenseBalanceSheet.getUserVsBalance();
                Balance paidByBalance = new Balance();
                boolean isPresent = false;
                for(var entry: paidByuserVsBalance.entrySet())
                {
                    User currUser = entry.getKey();
                    if(currUser.getUserId() == user.getUserId())
                    {
                        isPresent = true;
                        paidByBalance = entry.getValue();
                    }
                }
                if(isPresent)
                {
                    paidByBalance.setAmountGetBack(paidByBalance.getAmountGetBack()+split.getAmountOwe());
                }
                else
                {
                    paidByBalance.setAmountGetBack(split.getAmountOwe());
                    paidByuserVsBalance.put(user, paidByBalance);
                }

                //check if paidBy user is present in owe user balance sheet
                isPresent = false;
                Balance userOweBalance = new Balance();
                Map<User, Balance> userVsBalance = userExpenseBalanceSheet.getUserVsBalance();
                for(var entry: userVsBalance.entrySet())
                {
                    User currUser = entry.getKey();
                    if(currUser.getUserId() == paidBy.getUserId())
                    {
                        userOweBalance = entry.getValue();
                        isPresent = true;
                    }
                }
                if(isPresent)
                {
                    userOweBalance.setAmountOwe(userOweBalance.getAmountOwe()+split.getAmountOwe());
                }
                else
                {
                    userOweBalance.setAmountOwe(split.getAmountOwe());
                    userVsBalance.put(paidBy, userOweBalance);
                }

            }
        }
    }

    public void showBalanceSheetOfuser(User user)
    {
        System.out.println("-------------------");
        System.out.println("Printing Balance Sheet of User with userId: " + user.getUserId());
        System.out.println("Total Payment: " + user.getUserExpenseBalanceSheet().getTotalPayment());
        System.out.println("Total Expense: " + user.getUserExpenseBalanceSheet().getTotalYourExpense());
        System.out.println("Total AmountOwe: " + user.getUserExpenseBalanceSheet().getTotalYouOwe());
        System.out.println("Total AmountGetBack "+ user.getUserExpenseBalanceSheet().getTotalYouGetBack());
        for(var entry: user.getUserExpenseBalanceSheet().getUserVsBalance().entrySet())
        {
            User currUser = entry.getKey();
            Balance balance = entry.getValue();
            System.out.println("------------");
            System.out.println("Total amount owed to User "+ currUser.getUserName()+ " is "+ balance.getAmountOwe());
            System.out.println("Total amount gets back from User "+ currUser.getUserName()+ " is "+ balance.getAmountGetBack());
        }
        System.out.println("-------------------");
    }
}
