package LLDQuestions.ElevatorSystem;

import java.util.*;

import LLDQuestions.ElevatorSystem.enums.ElevatorState;
import LLDQuestions.ElevatorSystem.enums.ExternalButtonType;
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        List<Floor> floors = main.getFloors();
        List<ElevatorController> elevatorControllers = main.getElevatorControllers();
        Building building = new Building(elevatorControllers, floors, new BestScoreElevatorStrategy());

        Floor floor1 = building.getFloor(3);
        ExternalButton button1 = floor1.getButton(ExternalButtonType.UP);
        Request request1 = button1.click(floor1.floor);
        ElevatorController elevatorController1 = building.pickElevator(request1);
        elevatorController1.acceptNewRequest(request1);
        elevatorController1.processRequest();


        InternalButton button2 = elevatorController1.elevatorCar.getButtonByFloor(50);
        Request request2 = button2.click(elevatorController1);

        ElevatorController elevatorController2 = building.pickElevator(request2);
        elevatorController2.acceptNewRequest(request2);
        elevatorController2.processRequest();


        Floor floor2 = building.getFloor(7);
        ExternalButton button3 = floor2.getButton(ExternalButtonType.UP);
        Request request3 = button3.click(floor2.floor);

        ElevatorController elevatorController3 = building.pickElevator(request3);
        elevatorController3.acceptNewRequest(request3);
        elevatorController3.processRequest();

    }
    public List<Floor> getFloors()
    {
        List<Floor> floors = new ArrayList<>();
        for(int id=1;id<=50;id++)
        {
            List<ExternalButton> buttons = new ArrayList<>();
            buttons.add(new ExternalButton(ExternalButtonType.DOWN));
            buttons.add(new ExternalButton(ExternalButtonType.UP));
            Floor floor = new Floor(id, buttons);
            floors.add(floor);
        }
        return floors;
    }
    public List<ElevatorController> getElevatorControllers()
    {
        List<ElevatorController> elevatorControllers = new ArrayList<>();
        for(int id=1;id<=10;id++)
        {
            List<InternalButton> buttons = new ArrayList<>();
            for(int floor = 1; floor<=50; floor++)
            {
                buttons.add(new InternalButton(floor));
            }
            ElevatorCar elevatorCar = new ElevatorCar(id, 0, null, ElevatorState.IDLE, buttons);
            ElevatorController elevatorController = new ElevatorController(elevatorCar);
            elevatorControllers.add(elevatorController);
        }
        return elevatorControllers;
    }
}
