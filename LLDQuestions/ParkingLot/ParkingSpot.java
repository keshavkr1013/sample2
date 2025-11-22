package LLDQuestions.ParkingLot;

public class ParkingSpot {
    int spotId;
    boolean isEmpty;
    VehicleType vehicleType;
    Vehicle vehicle;
    public ParkingSpot(int spotId, VehicleType vehicleType)
    {
        this.spotId = spotId;
        this.isEmpty = true;
        this.vehicleType = vehicleType;
        this.vehicle = null;
    }
    public void bookParkingSpot(Vehicle vehicle)
    {
        isEmpty = false;
        this.vehicle = vehicle;
    }   
    public void freeParkingSpot(Vehicle vehcile)
    {
        isEmpty = true;
        this.vehicle = null;
    }
}
