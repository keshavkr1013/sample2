package LLDQuestions.ParkingLot;

import java.util.*;
public class ParkingLot {
    public static ParkingLot parkingLot = new ParkingLot(); //Eager initialization
    List<ParkingFloor> parkingFloors;
    private ParkingLot()
    {
        parkingFloors = new ArrayList<>();
    }
    public static ParkingLot getParkingLotObj()
    {
        return parkingLot;
    }
    public void addFloor(ParkingFloor parkingFloor)
    {
        parkingFloors.add(parkingFloor);
    }
    public ParkingSpot getParkingSpot(Vehicle vehicle)
    {
        for(ParkingFloor parkingFloor: parkingFloors)
        {
            for(ParkingSpot parkingSpot: parkingFloor.parkingSpots)
            {
                if(parkingSpot.isEmpty && parkingSpot.vehicleType == vehicle.vehicleType)
                {
                    System.out.println("Found parkingSpot with spotId: "+ parkingSpot.spotId + " for vehicle Type: "+ vehicle.vehicleType+ " in floor "+ parkingFloor.floorId);
                    return parkingSpot;
                }
            }
        }
        System.out.println("No Parking spot found for "+vehicle.vehicleType);
        return null;
    }
    public ParkingTicket parkVehicle(Vehicle vehicle, int startTime)
    {
        ParkingSpot parkingSpot  = getParkingSpot(vehicle);
        if(parkingSpot==null)
        {
            System.out.println("Unable to park vehicle as No parking Spot found");
            return null;
        }
        parkingSpot.bookParkingSpot(vehicle);
        System.out.println("Successfully Parked Vehicle");
        return new ParkingTicket(parkingSpot, vehicle, startTime);
    }

    public void unparkVehicle(ParkingTicket parkingTicket)
    {
        ParkingSpot parkingSpot = parkingTicket.parkingSpot;
        Vehicle vehicle = parkingTicket.vehicle;
        System.out.println("Successfully UnParked Vehicle");
        parkingSpot.freeParkingSpot(vehicle);
    }
}
