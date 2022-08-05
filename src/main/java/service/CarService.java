package service;

import dto.Car;
import dto.Ticket;

import java.util.UUID;

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
    }
}
