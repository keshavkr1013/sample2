package LLDQuestions.ParkingLot.ParkingFareStrategy;

import LLDQuestions.ParkingLot.*;
public interface FareStrategy {
    public int calculateFare(VehicleType vehicleType, int seconds);
}
