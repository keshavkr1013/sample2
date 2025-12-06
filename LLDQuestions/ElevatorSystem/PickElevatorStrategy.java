package LLDQuestions.ElevatorSystem;

import java.util.*;
public interface PickElevatorStrategy {
    public ElevatorController chooseElevatorCar(List<ElevatorController> elevatorControllers, Request request);
}
