package LLDQuestions.ParkingLot;

import LLDQuestions.ParkingLot.ParkingFareStrategy.FareStrategy;

public class CarVehicle extends Vehicle{
    CarVehicle(int vehicleId, FareStrategy fareStrategy)
    {
        super(vehicleId, VehicleType.CAR, fareStrategy);
    }
    
}
