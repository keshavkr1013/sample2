package LLDQuestions.ElevatorSystem;

import java.util.*;

import LLDQuestions.ElevatorSystem.enums.ElevatorDirection;
import LLDQuestions.ElevatorSystem.enums.ElevatorState;
import LLDQuestions.ElevatorSystem.enums.RequestType;
public class ElevatorController {
    ElevatorCar elevatorCar;
    TreeSet<Integer> upRequests = new TreeSet<>();
    TreeSet<Integer> downRequests = new TreeSet<>();
    public ElevatorController(ElevatorCar elevatorCar)
    {
        this.elevatorCar = elevatorCar;
    }
    public void acceptNewRequest(Request request)
    {
        int currFloor = elevatorCar.currFloor;
        int requestFloor = request.floor;
        if(currFloor == requestFloor)
        {
            System.out.println("Processed request as requested floor is same as current floor");
            return;
        }
        if(request.requestType == RequestType.CAR)
        {
            if(requestFloor>currFloor)
            {
                upRequests.add(requestFloor);
            }
            else
            {
                downRequests.add(requestFloor);
            }
        }
        else if(request.requestType == RequestType.UPWARD)
        {
            upRequests.add(requestFloor);
        }
        else
        {
            downRequests.add(requestFloor);
        }
    }
    public void processRequest()
    {
        ElevatorDirection direction = elevatorCar.direction;
        int currFloor = elevatorCar.currFloor;
        if(upRequests.isEmpty()&& downRequests.isEmpty())
        {
            System.out.println("No available requests to be processed");
            return;
        }
        if(elevatorCar.state==ElevatorState.IDLE)
        {
            elevatorCar.state = ElevatorState.MOVING;
            if(!upRequests.isEmpty())
            {
                elevatorCar.direction = ElevatorDirection.UP;
            }
            else
            {
                elevatorCar.direction = ElevatorDirection.DOWN;
            }
        }

        if(direction == ElevatorDirection.UP)
        {
            if(!upRequests.isEmpty())
            {
                int nextFloor = upRequests.ceiling(currFloor);
                elevatorCar.currFloor = nextFloor;
                System.out.println("Served up request by "+ elevatorCar.id+ " at nextFloor: "+ nextFloor);
                upRequests.remove(nextFloor);
            }
            else
            {
                elevatorCar.direction = ElevatorDirection.DOWN;
                processRequest();
            }
        }
        else
        {
            if(!downRequests.isEmpty())
            {
                int nextFloor = downRequests.floor(currFloor);
                elevatorCar.currFloor = nextFloor;
                System.out.println("Served down request by "+ elevatorCar.id+ " at nextFloor: "+ nextFloor);
                downRequests.remove(nextFloor);
            }
            else
            {
                elevatorCar.direction = ElevatorDirection.UP;
                processRequest();
            }
        }

    }
}
