package LLDQuestions.ParkingLot.ParkingFareStrategy;

import LLDQuestions.ParkingLot.*;
public class NormalFareStrategy implements FareStrategy{
    @Override
    public int calculateFare(VehicleType vehicleType, int seconds)
    {
        System.out.println("Normal Fare rate for "+ vehicleType+ " total duration of " + seconds);
        switch (vehicleType)
        {
            case VehicleType.BIKE:
                return seconds*5;
            case VehicleType.CAR:
                return seconds*10;
            case VehicleType.TRUCK:
                return seconds*15;
            default:
                return 0;
        }
    }
}
