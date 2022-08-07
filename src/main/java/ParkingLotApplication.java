import controller.CarController;
import controller.ParkingLotController;

public class ParkingLotApplication {

    public static void main(String[] args) {
        System.out.println("Starting the parking lot application!");
        ParkingLotController parkingLotController = new ParkingLotController();
        System.out.println("Starting to create parking lot with capacity for 6 slots");
        parkingLotController.createParkingLot(6);
        parkingLotController.parkCar("KA-01-HH-1234", "White");
        parkingLotController.parkCar("KA-01-HH-9999", "White");
        parkingLotController.parkCar("KA-01-BB-0001", "Black");
        parkingLotController.parkCar("KA-01-HH-7777", "Red");
        parkingLotController.parkCar("KA-01-HH-2701", "Blue");
        parkingLotController.parkCar("KA-01-HH-3141", "Black");
        parkingLotController.unparkCar(4);
        parkingLotController.getStatus();
        parkingLotController.parkCar("KA-01-P-333", "White");
        parkingLotController.parkCar("DL-12-AA-9999", "White");
        CarController carController = new CarController();
        carController.getCarRegistrationNosByColor("White");
        carController.getSlotNosByCarColor("White");
        carController.getSlotNoForRegistrationId("KA-01-HH-3141");
        carController.getSlotNoForRegistrationId("MH-04-AY-1111");
        parkingLotController.getStatus();
    }
}
