package LLDQuestions.ParkingLot.PaymentStrategy;

public class CardPayment implements PaymentMethod{
    @Override
    public void completePayment(int amount)
    {
        System.out.println("Successfully completed card Payment for RS: " + amount);
    }
}
