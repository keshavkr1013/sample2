package LLDQuestions.NotificationSystem;


public class IphoneObservable extends Observable{
    IphoneObservable(String name, int stockCount)
    {
        super(name, stockCount);
    }
    public String getName()
    {
        return name;
    }
    public void addObserver(Observer observer)
    {
        observers.add(observer);
    }
    public void removeObserver(Observer observer)
    {
        observers.remove(observer);
    }
    public void notifySubscribers()
    {
        for(Observer observer: observers)
        {
            observer.update();
        }
    }
    public void setStockCount(int count)
    {
        boolean shouldNotify = false;
        //important not to take lock over complete method because observers can be slow
        //which can cause starvation, deadlocks and increase latency as other threads will be blocked
        synchronized (this) {
            if (stockCount == 0 && count > 0) {
                shouldNotify = true;
            }
            stockCount = count;
        }
        if(shouldNotify)
        {
            notifySubscribers();
        }
    }
    public int getStockCount()
    {
        return stockCount;
    }
}
