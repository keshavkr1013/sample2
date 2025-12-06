package LLDQuestions.ElevatorSystem;

import LLDQuestions.ElevatorSystem.enums.*;
import java.util.*;
public class ElevatorCar {
    int id;
    int currFloor;
    ElevatorDirection direction;
    ElevatorState state;
    List<InternalButton> buttons;
    public ElevatorCar(int id, int currFloor, ElevatorDirection direction, ElevatorState state, List<InternalButton> buttons)
    {
        this.id = id;
        this.currFloor = currFloor;
        this.direction = direction;
        this.state = state;
        this.buttons = buttons;
    }
    public void move(ElevatorDirection direction, ElevatorState state, int currFloor)
    {
        this.currFloor = currFloor;
        this.direction = direction;
        this.state = state;
    }
    public InternalButton getButtonByFloor(int floor)
    {
        for(InternalButton button: buttons)
        {
            if(button.floor==floor)
            {
                return button;
            }
        }
        return null;
    }
}
