package LLDQuestions.ElevatorSystem;

import LLDQuestions.ElevatorSystem.enums.ExternalButtonType;
import LLDQuestions.ElevatorSystem.enums.RequestType;

public class ExternalButton {
    ExternalButtonType buttonType;
    public ExternalButton(ExternalButtonType buttonType)
    {
        this.buttonType = buttonType;
    }
    public Request click(int floor)
    {
        int requestId = RequestIdGenerator.nextId();
        Request request = new Request(requestId, null, (buttonType==ExternalButtonType.UP)?RequestType.UPWARD: RequestType.DOWNWARD, floor);
        return request;
    }
}
