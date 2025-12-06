package LLDQuestions.ElevatorSystem;

import LLDQuestions.ElevatorSystem.enums.RequestType;

public class Request {
    int requestId;
    ElevatorController elevatorController;
    RequestType requestType;
    int floor;
    public Request(int requestId, ElevatorController elevatorController, RequestType requestType, int floor)
    {
        this.requestId = requestId;
        this.elevatorController = elevatorController;
        this.requestType = requestType;
        this.floor = floor;
    }
}
