package LLDQuestions.ElevatorSystem;

import java.util.*;

import LLDQuestions.ElevatorSystem.enums.ElevatorDirection;
import LLDQuestions.ElevatorSystem.enums.ElevatorState;
public class BestScoreElevatorStrategy implements PickElevatorStrategy{
    int calculateElevatorScore(ElevatorCar car, Request request)
    {
        int score=0;
        if((car.direction==ElevatorDirection.UP && request.floor>=car.currFloor) || (car.direction==ElevatorDirection.DOWN && request.floor<=car.currFloor))
        {
            score = 20+(100-Math.abs(request.floor-car.currFloor));
        }
        else if(car.state==ElevatorState.IDLE)
        {
            score = 10+(100-Math.abs(request.floor-car.currFloor));
        }
        else
        {
            score = (100-Math.abs(request.floor-car.currFloor));
        }
        return score;
    }
    public ElevatorController chooseElevatorCar(List<ElevatorController> elevatorControllers, Request request)
    {
        ElevatorController bestElevatorController=null;
        int score=0;
        for(ElevatorController controller: elevatorControllers)
        {
            ElevatorCar car = controller.elevatorCar;
            int currScore = calculateElevatorScore(car, request);
            if(currScore>score)
            {
                bestElevatorController=controller;
                score=currScore;
            }
        }
        return bestElevatorController;
    }
}
