package LLDQuestions.MyDesignATM;

import java.util.*;
public class ATMRoom {
    ATM atm;
    User user;

    public static void main(String[] args) {
        ATMRoom atmRoom = new ATMRoom();
        atmRoom.initialize();
        ATM atm = atmRoom.atm;
        User user = atmRoom.user;
        atmRoom.atm.getAtmState().insertCard(atm, user.getCard());
        Scanner scanner = new Scanner(System.in);
        int pin = scanner.nextInt();
        atmRoom.atm.getAtmState().authenticatePin(atm, user.getCard(), pin);

        // String operation = scanner.nextLine();

        // TransactionType tp;
        // if(operation.equals(TransactionType.BALANCE_CHECK.values())
        atmRoom.atm.getAtmState().selectOperation(atm, user.getCard(), TransactionType.CASH_WITHDRAWAL);

        
        int withDrawAmount = scanner.nextInt();
        atmRoom.atm.getAtmState().cashWithdraw(atm, user.getCard(), withDrawAmount);
        
        atmRoom.atm.printCurrentATMStatus();
        System.out.println("Card Balance for user is " + user.getCard().getBankBalance());

        // else 
        //     atmRoom.atm.getAtmState().selectOperation(atm, user.getCard(), TransactionType.BALANCE_CHECK);
        scanner.close();

    }

    public void initialize()
    {
        ATM atm = ATM.getATMobj();
        atm.setAtmBalance(4000, 1, 2, 5);

        User user = createUser();

        this.atm = atm;
        this.user = user;
    }

    public User createUser()
    {
        User user = new User();
        UserBankAccount bankAccount = new UserBankAccount();
        bankAccount.setBankBalance(3000);
        Card card = new Card();
        card.setPin(91322);
        card.setAccountBalance(bankAccount);
        user.setCard(card);
        return user;
    }
    
}
