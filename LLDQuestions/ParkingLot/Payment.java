package LLDQuestions.ParkingLot;

import LLDQuestions.ParkingLot.PaymentStrategy.*;
public class Payment {
    PaymentMethod paymentMethod;
    public Payment(PaymentMethod paymentMethod)
    {
        this.paymentMethod = paymentMethod;
    }
    public static PaymentMethod getPaymentStrategy(String method)
    {
        switch(method.toLowerCase())
        {
            case "cash":
                return new CashPayment();
            case "card":
                return new CardPayment();
            case "upi":
                return new UPIPayment();
            default:
                return null;
        }
    }
}
