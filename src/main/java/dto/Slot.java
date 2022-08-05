package dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Slot {

    private int slotNo;
    private String carRegistrationId;
    private boolean isReserved;

    public Slot(int slotNo) {
        this.slotNo = slotNo;
        isReserved = false;
    }
}
