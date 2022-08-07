package controller;

import service.ParkingLotService;

public class ParkingLotController {

    ParkingLotService parkingLotService = new ParkingLotService();

    public void createParkingLot(int capacity) {
        parkingLotService.createInstance(capacity);
    }

    public void parkCar(String registrationId, String color) {
        parkingLotService.parkCar(registrationId, color);
    }

    public void unparkCar(int slotId) {
        parkingLotService.unparkCar(slotId);
    }

    public void getStatus() {
        parkingLotService.getStatus();
    }
}
