package LLDQuestions.PizzaCost;

public class FarmHouse implements BasePizza{
    @Override //override is not necessary but it is cleaner to make sure we are overriding not overloading method
    public int getCost()
    {
        return 10;
    }
}
