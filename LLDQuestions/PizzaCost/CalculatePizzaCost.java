package LLDQuestions.PizzaCost;

import LLDQuestions.PizzaCost.Decorators.*;
public class CalculatePizzaCost {
    public static void main(String[] args) {
        BasePizza pizza = new MushroomDecorator(new CheeseDecorator(new FarmHouse()));

        BasePizza pizza2 = new MushroomDecorator(new MushroomDecorator(new CheeseDecorator(new VegDelight())));
        System.out.println(pizza.getCost());
        System.out.println(pizza2.getCost());
    }
}
