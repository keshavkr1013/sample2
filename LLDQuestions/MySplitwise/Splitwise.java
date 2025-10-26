package LLDQuestions.MySplitwise;


import LLDQuestions.MySplitwise.User.*;
import LLDQuestions.MySplitwise.Expense.*;
import LLDQuestions.MySplitwise.Expense.Split.*;
import java.util.*;


public class Splitwise {
    UserController userController = new UserController();
    ExpenseController expenseController = new ExpenseController();
    BalanceSheetController balanceSheetController = new BalanceSheetController();
    
    public static void main(String[] args) {
        Splitwise splitwise = new Splitwise();
        splitwise.initialize();

    }

    void initialize()
    {
        addUsers();
        for(User user: userController.getAllUsers())
        {
            balanceSheetController.showBalanceSheetOfuser(user);
        }
        List<Split> splits = new ArrayList<>();
        

        User user1 = userController.getUserByUserId(1);
        User user2 = userController.getUserByUserId(2);
        User user3 = userController.getUserByUserId(3);
        User user4 = userController.getUserByUserId(4);

        Split split1 = new Split(user1, 100, 0);
        Split split2 = new Split(user2, 100, 0);
        Split split3 = new Split(user3, 100, 0);

        splits.add(split1);
        splits.add(split2);
        splits.add(split3);

        expenseController.createExpense(1, "Expense 1", splits, user1, ExpenseSplitType.EQUAL, 300);

        for(User user: userController.getAllUsers())
        {
            balanceSheetController.showBalanceSheetOfuser(user);
        }

        splits = new ArrayList<>();

        split1 = new Split(user2, 50, 0);
        split2 = new Split(user3, 100, 0);
        split3 = new Split(user4, 150, 0);
        
        splits.add(split1);
        splits.add(split2);
        splits.add(split3);

        expenseController.createExpense(2, "Expense 2", splits, user2, ExpenseSplitType.UNEQUAL, 300);

        for(User user: userController.getAllUsers())
        {
            balanceSheetController.showBalanceSheetOfuser(user);
        }


        splits = new ArrayList<>();

        split1 = new Split(user2, 0, 30);
        split2 = new Split(user3, 0, 30);
        split3 = new Split(user4, 0, 40);
        
        splits.add(split1);
        splits.add(split2);
        splits.add(split3);

        expenseController.createExpense(3, "Expense 3", splits, user3, ExpenseSplitType.PERCENTAGE, 300);

        for(User user: userController.getAllUsers())
        {
            balanceSheetController.showBalanceSheetOfuser(user);
        }

    }

    void addUsers()
    {
        User user1 = new User();
        user1.setUserId(1);
        user1.setUserName("Shyam");

        User user2 = new User();
        user2.setUserId(2);
        user2.setUserName("Keshav");

        User user3 = new User();
        user3.setUserId(3);
        user3.setUserName("Shubham");

        User user4 = new User();
        user4.setUserId(4);
        user4.setUserName("Suman");

        userController.addUser(user1);
        userController.addUser(user2);
        userController.addUser(user3);
        userController.addUser(user4);


    }


}
