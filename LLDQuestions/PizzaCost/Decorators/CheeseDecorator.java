package LLDQuestions.PizzaCost.Decorators;

import LLDQuestions.PizzaCost.*;
public class CheeseDecorator implements PizzaDecorator{
    BasePizza basePizza;
    public CheeseDecorator(BasePizza basePizza)
    {
        this.basePizza = basePizza;
    }
    public int getCost()
    {
        return basePizza.getCost() + 5;
    }
    
}
