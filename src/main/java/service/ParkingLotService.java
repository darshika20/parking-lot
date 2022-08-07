package service;

import dto.Car;
import dto.ParkingLot;
import dto.Slot;
import entity.SlotRepository;

import java.util.HashMap;

public class ParkingLotService {

    private ParkingLot parkingLot;

    private CarService carService = new CarService();

    public void createInstance(int capacity) {
        parkingLot = ParkingLot.createInstance(capacity);
        if (parkingLot != null) {
            System.out.println("Created a parking lot with " + parkingLot.getCapacity() + " slots");
        }
    }

    public void parkCar(String registrationId, String color) {

        Slot slot = parkingLot.getParkingStrategy().allocateSlot();
        if (slot != null) {
            Car car = carService.createCar(registrationId, color);
            carService.assignTicket(car, slot.getSlotNo());
            parkingLot.getParkedCars().add(car);
            slot.setCar(car);
            slot.setReserved(true);
            saveInRepository(slot);
            System.out.println("Successfully parked car " + car.getRegistrationId() + " in slot " + slot.getSlotNo());
        }
    }

    private void saveInRepository(Slot slot) {

        if (SlotRepository.slotIdVsSlot == null) {
            SlotRepository.slotIdVsSlot = new HashMap<>();
        }
        SlotRepository.slotIdVsSlot.put(slot.getSlotNo(), slot);
        System.out.println("Saved slot details in repository");
    }

    public void unparkCar(int slotId) {

        Slot slot = parkingLot.getParkingStrategy().deallocateSlot(slotId);
        Car car = slot.getCar();
        slot.setReserved(false);
        slot.setCar(null);
        // remove this car from parked cars
        parkingLot.getParkedCars().remove(car);
        // remove this car from car repository
        carService.removeCar(car);
        System.out.println("Successfully unparked car " + car.getRegistrationId() + "from Slot number "
                + slotId + " is free");
    }

    public void getStatus() {
        parkingLot.getParkingStrategy().status();
    }
}
