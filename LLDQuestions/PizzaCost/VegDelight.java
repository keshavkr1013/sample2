package LLDQuestions.PizzaCost;

public class VegDelight implements BasePizza{
    @Override //override is not necessary but it is cleaner to make sure we are overriding not overloading method
    public int getCost()
    {
        return 15;
    }
}
