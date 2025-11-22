package LLDQuestions.PizzaCost.Decorators;

import LLDQuestions.PizzaCost.*;
public class MushroomDecorator implements PizzaDecorator{
    BasePizza basePizza;
    public MushroomDecorator(BasePizza basePizza)
    {
        this.basePizza = basePizza;
    }
    @Override //override is not necessary but it is cleaner to make sure we are overriding not overloading method
    public int getCost()
    {
        return basePizza.getCost() + 10;
    }
}
