package LLDQuestions.ParkingLot;
import LLDQuestions.ParkingLot.ParkingFareStrategy.*;
public class Vehicle {
    int vehicleId;
    VehicleType vehicleType;
    FareStrategy fareStrategy;

    Vehicle(int vehicleId, VehicleType vehicleType, FareStrategy fareStrategy)
    {
        this.vehicleId = vehicleId;
        this.vehicleType = vehicleType;
        this.fareStrategy = fareStrategy;
    }
    
    
}
