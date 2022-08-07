package strategy;

import dto.Car;
import dto.ParkingLot;
import dto.Slot;
import entity.SlotRepository;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

@Getter
@Setter
public class NearestSlotFromEntry implements ParkingStrategy{

    private PriorityQueue<Slot> availableSlots;
    private List<Slot> allottedSlots;
    private int capacity;

    public NearestSlotFromEntry(int capacity) {
        this.capacity = capacity;
        availableSlots = new PriorityQueue<>(Comparator.comparingInt(Slot::getSlotNo));
        allottedSlots = new ArrayList<>();
        for (int i = 0; i < capacity; i++) {
            availableSlots.add(new Slot(i+1));
        }
    }

    @Override
    public Slot allocateSlot() {
        if (availableSlots.isEmpty()) {
            System.out.println("Sorry, parking lot is full");
            return null;
        } else {
            Slot slot = availableSlots.poll();
            allottedSlots.add(slot);
            System.out.println("Allocated slot number: " + slot.getSlotNo());
            return slot;
        }
    }

    @Override
    public Slot deallocateSlot(int slotId) {
        if (slotId > ParkingLot.getParkingLot().getCapacity()) {
            System.out.println("Invalid slot no!");
            return null;
        }
        Slot slot = SlotRepository.slotIdVsSlot.get(slotId);
        if (slot == null || !allottedSlots.contains(slot)) {
            System.out.println("No car is parked in this slot!");
            return null;
        }
        allottedSlots.remove(slot);
        availableSlots.add(slot);
        System.out.println("Slot number " + slotId + " is free");
        return slot;
    }

    @Override
    public void status() {
        for (Slot slot : allottedSlots) {
            Car car = slot.getCar();
            System.out.println(slot.getSlotNo() + " " + car.getRegistrationId() + " " + car.getColor());
        }
    }
}
