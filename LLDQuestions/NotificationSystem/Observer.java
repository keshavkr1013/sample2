package LLDQuestions.NotificationSystem;



public abstract class Observer {
    Observable observable;
    Observer(Observable observable)
    {
        this.observable = observable;
    }
    public abstract void update();
}
