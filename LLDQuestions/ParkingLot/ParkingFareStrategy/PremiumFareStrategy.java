

package LLDQuestions.ParkingLot.ParkingFareStrategy;

import LLDQuestions.ParkingLot.*;
public class PremiumFareStrategy implements FareStrategy{
    @Override
    public int calculateFare(VehicleType vehicleType, int seconds)
    {
        System.out.println("Premium Fare rate for "+ vehicleType+ " total duration of " + seconds);
        switch (vehicleType)
        {
            case VehicleType.BIKE:
                return seconds*5+10;
            case VehicleType.CAR:
                return seconds*10+10;
            case VehicleType.TRUCK:
                return seconds*15+10;
            default:
                return 0;
        }
    }
}
