package LLDQuestions.NotificationSystem;


import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class Observable {
    int stockCount;
    String name;
    List<Observer> observers;

    // observers is CopyOnWriteArrayList here to ensure thread safety when multiple threads try to modify 
    // list of observers. This creates a copy and locks write for other threads while reads continue to
    // happen on older set of observers

    //This is efficient when number of reads is quite high which notifySubscribers() here while writes
    //updating observers of a observable is less frequent

    //using synchronized block, or ReadWriteLock on addObserver/removeObserver is not correct because
    //ConcurrentModificationException as notifySubscribers stockCount can cause conflict if thread 1
    //updates Observers list while thread 2 is trying to notifySubscribers

    Observable(String name, int stockCount)
    {
        this.stockCount = stockCount;
        this.name = name;
        this.observers = new CopyOnWriteArrayList<>();
    }
    
    public abstract void addObserver(Observer observer);
    public abstract String getName();

    public abstract void removeObserver(Observer observer);
    public abstract void notifySubscribers();

    public abstract void setStockCount(int count);
    public abstract int getStockCount();
}
