package LLDQuestions.ParkingLot;

import LLDQuestions.ParkingLot.ParkingFareStrategy.FareStrategy;

public class BikeVehicle extends Vehicle{
    BikeVehicle(int vehicleId, FareStrategy fareStrategy)
    {
        super(vehicleId, VehicleType.BIKE, fareStrategy);
    }
}
