package LLDQuestions.NotificationSystem;



public class Main {
    public static void main(String[] args) {
        Observable observable = new IphoneObservable("Iphone", 2);
        Observer observer1 = new EmailObserver(observable);
        Observer observer2 = new SMSObserver(observable);
        observable.addObserver(observer1);
        observable.addObserver(observer2);

        observable.setStockCount(0);
        observable.setStockCount(10);
        observable.setStockCount(15);
        observable.setStockCount(0);
        observable.setStockCount(20);

    }
}
