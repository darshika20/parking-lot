package dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class Ticket {

    private String carRegistrationId;
    private String carColor;
    private int slotId;
    private String ticketId;
}
