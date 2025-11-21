package LLDQuestions.PizzaCost.Decorators;

import LLDQuestions.PizzaCost.*;
public class MushroomDecorator implements PizzaDecorator{
    BasePizza basePizza;
    public MushroomDecorator(BasePizza basePizza)
    {
        this.basePizza = basePizza;
    }
    public int getCost()
    {
        return basePizza.getCost() + 10;
    }
}
