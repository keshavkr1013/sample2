package LLDQuestions.ParkingLot;
import java.util.*;
import LLDQuestions.ParkingLot.PaymentStrategy.*;
import LLDQuestions.ParkingLot.ParkingFareStrategy.*;

public class Main {
    public static void main(String[] args) {
        ParkingLot parkingLot = ParkingLot.getParkingLotObj();
        addFloors(parkingLot);

        //vehicle 1
        Vehicle vehicle1 = new CarVehicle(1, new NormalFareStrategy());
        ParkingTicket parkingTicket1 = parkingLot.parkVehicle(vehicle1, 100);

        // vehicle 2
        Vehicle vehicle2 = new CarVehicle(2, new PremiumFareStrategy());
        ParkingTicket parkingTicket2 = parkingLot.parkVehicle(vehicle2, 100);

        int amount1 = vehicle1.fareStrategy.calculateFare(vehicle1.vehicleType, 150);
        PaymentMethod paymentMethod1 = Payment.getPaymentStrategy("CARD");
        Payment payment1 = new Payment(paymentMethod1);
        payment1.paymentMethod.completePayment(amount1);
        parkingLot.unparkVehicle(parkingTicket1);


        int amount2 = vehicle2.fareStrategy.calculateFare(vehicle2.vehicleType, 200);
        PaymentMethod paymentMethod2 = Payment.getPaymentStrategy("CASH");
        Payment payment2 = new Payment(paymentMethod2);
        payment2.paymentMethod.completePayment(amount2);
        parkingLot.unparkVehicle(parkingTicket2);
        
        //vehicle 3
        Vehicle vehicle3 = new CarVehicle(3, new NormalFareStrategy());
        ParkingTicket parkingTicket3 = parkingLot.parkVehicle(vehicle3, 100);

        //vehicle 4
        Vehicle vehicle4 = new BikeVehicle(4, new NormalFareStrategy());
        ParkingTicket parkingTicket4 = parkingLot.parkVehicle(vehicle4, 100);

        parkingLot.unparkVehicle(parkingTicket3);
        parkingLot.unparkVehicle(parkingTicket4);

    }
    public static void addFloors(ParkingLot parkingLot)
    {
        // floor 1
        List<ParkingSpot> parkingSpots = new ArrayList<>();
        for(int spotId=1;spotId<=10;spotId++)
        {
            ParkingSpot parkingSpot = new ParkingSpot(spotId, VehicleType.CAR);
            parkingSpots.add(parkingSpot);
        }
        for(int spotId=11;spotId<=20;spotId++)
        {
            ParkingSpot parkingSpot = new ParkingSpot(spotId, VehicleType.TRUCK);
            parkingSpots.add(parkingSpot);
        }
        ParkingFloor parkingFloor1 = new ParkingFloor(1, parkingSpots);

        // floor 2
        parkingSpots = new ArrayList<>();
        for(int spotId=1;spotId<=20;spotId++)
        {
            ParkingSpot parkingSpot = new ParkingSpot(spotId, VehicleType.BIKE);
            parkingSpots.add(parkingSpot);
        }
        ParkingFloor parkingFloor2 = new ParkingFloor(2, parkingSpots);

        parkingLot.addFloor(parkingFloor1);
        parkingLot.addFloor(parkingFloor2);

    }
}
