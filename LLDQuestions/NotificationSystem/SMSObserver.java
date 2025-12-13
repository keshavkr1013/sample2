package LLDQuestions.NotificationSystem;

public class SMSObserver extends Observer{
    SMSObserver(Observable observable)
    {
        super(observable);
    }
    public void update()
    {
        System.out.println("Product "+observable.getName()+ " is back in stock, total stock count is "+observable.getStockCount());
        System.out.println("Sent SMS to the user");
    }
}
