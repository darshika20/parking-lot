package dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Car {

    private Ticket ticket;
    private String registrationId;
    private String color;

    public Car (String registrationId, String color) {
        this.registrationId = registrationId;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car{" +
                "ticket=" + ticket +
                ", registrationId='" + registrationId + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
