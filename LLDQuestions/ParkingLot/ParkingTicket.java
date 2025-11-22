package LLDQuestions.ParkingLot;

public class ParkingTicket {
    ParkingSpot parkingSpot;
    Vehicle vehicle;
    int startTime;
    public ParkingTicket(ParkingSpot parkingSpot, Vehicle vehicle, int startTime)
    {
        this.parkingSpot = parkingSpot;
        this.vehicle = vehicle;
        this.startTime = startTime;
    }

}
