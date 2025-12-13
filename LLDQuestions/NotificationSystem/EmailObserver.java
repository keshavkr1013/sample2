package LLDQuestions.NotificationSystem;

public class EmailObserver extends Observer{
    EmailObserver(Observable observable)
    {
        super(observable);
    }
    public void update()
    {
        System.out.println("Product "+observable.getName()+ " is back in stock, total stock count is "+observable.getStockCount());
        System.out.println("Sent Email to the user");
    }
}
