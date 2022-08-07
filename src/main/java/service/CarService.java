package service;

import dto.Car;
import dto.Ticket;
import entity.CarRepository;
import org.apache.commons.collections4.CollectionUtils;

import java.util.*;

public class CarService {

    public Car createCar(String registrationId, String color) {
        return new Car(registrationId, color);
    }

    public void assignTicket(Car car, int slotNo) {
        Ticket ticket = Ticket.builder().ticketId(UUID.randomUUID().toString())
                .carColor(car.getColor())
                .carRegistrationId(car.getRegistrationId())
                .slotId(slotNo)
                .build();
        car.setTicket(ticket);
        saveInRepository(car);
        System.out.println("Assigned ticket to the car");
    }

    private void saveInRepository(Car car) {

        if (CarRepository.colorVsCar == null) {
            CarRepository.colorVsCar = new HashMap<>();
        }
        if (!CarRepository.colorVsCar.containsKey(car.getColor())) {
            CarRepository.colorVsCar.put(car.getColor(), new ArrayList<>());
        }
        CarRepository.colorVsCar.get(car.getColor()).add(car);

        if (CarRepository.registrationIdVsCar == null) {
            CarRepository.registrationIdVsCar = new HashMap<>();
        }
        CarRepository.registrationIdVsCar.put(car.getRegistrationId(), car);
        System.out.println("Added car to the database");
    }

    public void removeCar(Car car) {

        CarRepository.colorVsCar.get(car.getColor()).remove(car);
        CarRepository.registrationIdVsCar.remove(car.getRegistrationId());
        System.out.println("Removed car from database");
    }

    public void getCarRegistrationNosByColor(String color) {

        if (carWithColorPresent(color)) {
            System.out.println("Cars with color: " + color);
            for (Car car : CarRepository.colorVsCar.get(color)) {
                System.out.println(car.getRegistrationId());
            }
        }
    }

    public void getSlotNosByCarColor(String color) {

        if (carWithColorPresent(color)) {
            System.out.println("Slot Ids with color: " + color);
            CarRepository.colorVsCar.get(color).forEach(car -> System.out.println(car.getTicket().getSlotId()));
        }
    }

    private boolean carWithColorPresent(String color) {

        if (CollectionUtils.isEmpty(CarRepository.colorVsCar.get(color))) {
            System.out.println("No car present in parking lot with this color!");
            return false;
        }
        return true;
    }

    public void getSlotNoForRegistrationId(String registrationId) {

        if (!CarRepository.registrationIdVsCar.containsKey(registrationId)) {
            System.out.println("Not found");
            return;
        } else {
            System.out.println("Slot no " + CarRepository.registrationIdVsCar.get(registrationId).getTicket()
                    .getSlotId() + " is allocated to " + registrationId);
        }
    }
}
