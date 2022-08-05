package service;

import dto.Car;
import dto.ParkingLot;
import dto.Slot;

public class ParkingLotService {

    private ParkingLot parkingLot;

    private CarService carService;

    public void createInstance(int capacity) {
        parkingLot = ParkingLot.createInstance(capacity);
        if (parkingLot != null) {
            System.out.println("Created a parking lot with " + parkingLot.getCapacity() + " slots");
        }
    }

    public void parkCar(String registrationId, String color) {

        if (parkingLot.getAvailableSlots().isEmpty()) {
            System.out.println("Sorry, parking lot is full");
            return;
        } else {
            Car car = carService.createCar(registrationId, color);
            Slot slot = parkingLot.getAvailableSlots().poll();
            carService.assignTicket(car, slot.getSlotNo());
            parkingLot.getAllottedSlots().add(slot);
            parkingLot.getParkedCars().add(car);
            System.out.println("Allocated slot number: " + slot.getSlotNo());
        }
    }
}
