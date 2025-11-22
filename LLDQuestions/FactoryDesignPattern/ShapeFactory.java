package LLDQuestions.FactoryDesignPattern;

public class ShapeFactory {
    Shape getShape(String value)
    {
        if(value == "circle")
        {
            return new Circle();
        }
        else if(value == "rectangle")
        {
            return new Rectangle();
        }
        else
            return new Circle();
    }
}
