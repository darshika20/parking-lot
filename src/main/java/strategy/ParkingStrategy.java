package strategy;

import dto.Slot;

public interface ParkingStrategy {

    Slot allocateSlot();
    Slot deallocateSlot(int slotId);
    void status();
}
