package LLDQuestions.ElevatorSystem;

import java.util.*;

import LLDQuestions.ElevatorSystem.enums.RequestType;
public class Building {
    List<ElevatorController> elevatorControllers;
    List<Floor> floors;
    PickElevatorStrategy pickElevatorStrategy;
    public Building(List<ElevatorController> elevatorControllers, List<Floor> floors, PickElevatorStrategy pickElevatorStrategy)
    {
        this.elevatorControllers = elevatorControllers;
        this.floors = floors;
        this.pickElevatorStrategy = pickElevatorStrategy;
    }
    public ElevatorController pickElevator(Request request)
    {
        if(request.requestType == RequestType.CAR)
        {
            return request.elevatorController;
        }
        else
        {
            return pickElevatorStrategy.chooseElevatorCar(elevatorControllers, request);
        }
    }
    public Floor getFloor(int floorId)
    {
        for(Floor currfloor: floors)
        {
            if(currfloor.floor == floorId)
                return currfloor;
        }
        return null;
    }
}
