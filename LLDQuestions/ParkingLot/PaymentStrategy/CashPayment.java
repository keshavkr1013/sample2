package LLDQuestions.ParkingLot.PaymentStrategy;

public class CashPayment implements PaymentMethod{
    @Override
    public void completePayment(int amount)
    {
        System.out.println("Successfully completed cash Payment for RS: " + amount);
    }
}
