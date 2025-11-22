package LLDQuestions.ParkingLot;

import java.util.*;
public class ParkingFloor {
    int floorId;
    List<ParkingSpot> parkingSpots = new ArrayList<>();

    public ParkingFloor(int floorId, List<ParkingSpot> parkingSpots)
    {
        this.floorId = floorId;
        this.parkingSpots = parkingSpots;
    }

    public void addParkingSpot(ParkingSpot parkingSpot)
    {
        parkingSpots.add(parkingSpot);
    }

    public void removeParkingSpot(ParkingSpot parkingSpot)
    {
        parkingSpots.remove(parkingSpot);
    }

}
