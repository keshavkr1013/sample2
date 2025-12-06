package LLDQuestions.ElevatorSystem;

import java.util.*;

import LLDQuestions.ElevatorSystem.enums.ExternalButtonType;
public class Floor {
    int floor;
    List<ExternalButton> buttons;
    public Floor(int floor, List<ExternalButton> buttons)
    {
        this.floor = floor;
        this.buttons = buttons;
    }
    public ExternalButton getButton(ExternalButtonType buttonType)
    {
        for(ExternalButton currButton: buttons)
        {
            if(currButton.buttonType==buttonType)
            {
                return currButton;
            }
        }
        return null;
    }
}
