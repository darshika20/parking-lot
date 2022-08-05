package dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Car {

    private Ticket ticket;
    private String registrationId;
    private String color;

    public Car (String registrationId, String color) {
        this.registrationId = registrationId;
        this.color = color;
    }
}
