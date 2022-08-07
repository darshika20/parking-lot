package dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Slot {

    private int slotNo;
    private Car car;
    private boolean isReserved;

    public Slot(int slotNo) {
        this.slotNo = slotNo;
        isReserved = false;
    }
}
