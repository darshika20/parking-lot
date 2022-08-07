package controller;

import service.CarService;

public class CarController {

    private CarService carService = new CarService();

    public void getCarRegistrationNosByColor(String color) {
        carService.getCarRegistrationNosByColor(color);
    }

    public void getSlotNosByCarColor(String color) {
        carService.getSlotNosByCarColor(color);
    }

    public void getSlotNoForRegistrationId(String registrationId) {
        carService.getSlotNoForRegistrationId(registrationId);
    }
}
