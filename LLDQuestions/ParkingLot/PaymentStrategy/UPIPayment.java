package LLDQuestions.ParkingLot.PaymentStrategy;

public class UPIPayment implements PaymentMethod{
    @Override
    public void completePayment(int amount)
    {
        System.out.println("Successfully completed UPI Payment for RS: " + amount);
    }
}
