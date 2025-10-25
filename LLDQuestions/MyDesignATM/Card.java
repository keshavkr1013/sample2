package LLDQuestions.MyDesignATM;

public class Card {
    int cardNumber;
    int cvv;
    String holderName;
    int pinNumber;
    UserBankAccount bankAccount;

    public boolean isCorrectPINentered(int pin)
    {
        if(pin == pinNumber)
            return true;
        else
            return false;
    }

    public void setPin(int pin)
    {
        this.pinNumber = pin;
    }
    public void deductBalance(int amount)
    {
        bankAccount.withdrawalBalance(amount);
    }

    public int getBankBalance()
    {
        return bankAccount.balance;
    }

    public void setAccountBalance(UserBankAccount bankAccount)
    {
        this.bankAccount = bankAccount;
    }
}
