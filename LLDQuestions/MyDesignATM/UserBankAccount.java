package LLDQuestions.MyDesignATM;

public class UserBankAccount {
    int balance;

    public void setBankBalance(int amount)
    {
        balance = amount;
    }
    public void withdrawalBalance(int amount)
    {
        balance -= amount;
    }
}
