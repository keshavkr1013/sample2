package LLDQuestions.ElevatorSystem;

import LLDQuestions.ElevatorSystem.enums.RequestType;

public class InternalButton {
    int floor;
    public InternalButton(int floor)
    {
        this.floor = floor;
    }
    public Request click(ElevatorController elevatorController)
    {
        int requestId = RequestIdGenerator.nextId();
        Request request = new Request(requestId, elevatorController, RequestType.CAR, floor);
        return request;
    }
}
