package dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ParkingLot {

    private int capacity;

    private List<Slot> slots;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        slots = new ArrayList<>();
    }
}
