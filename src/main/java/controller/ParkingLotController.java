package controller;

import dto.ParkingLot;
import service.ParkingLotService;

public class ParkingLotController {

    ParkingLotService parkingLotService = new ParkingLotService();

    public void createParkingLot(int capacity) {
        parkingLotService.createInstance(capacity);
    }

    public void parkCar(String registrationId, String color) {
        parkingLotService.parkCar(registrationId, color);
    }
}
