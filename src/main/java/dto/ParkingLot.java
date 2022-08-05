package dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Logger;

@Getter
@Setter
@Builder
@Slf4j
public class ParkingLot {

    private int capacity;

    private PriorityQueue<Slot> availableSlots;

    private List<Slot> allottedSlots;

    private List<Car> parkedCars;

    private static ReentrantLock lock;

    private ParkingLot(int capacity) {
        this.capacity = capacity;
        availableSlots = new PriorityQueue<>(Comparator.comparingInt(Slot::getSlotNo));
        allottedSlots = new ArrayList<>();
        parkedCars = new ArrayList<>();
        for (int i = 0; i < capacity; i++) {
            availableSlots.add(new Slot(i+1));
        }
    }

    private static ParkingLot parkingLot;

    public static ParkingLot createInstance(int capacity) {
        if (parkingLot == null) {
            try {
                lock.lock();
                parkingLot = new ParkingLot(capacity);
            } catch (Exception e) {
                System.out.println("Failed to create parking lot with exception " + e.getMessage());
            } finally {
                lock.unlock();
            }
        }
        return parkingLot;
    }

    public static ParkingLot getParkingLot() {
        return parkingLot;
    }
}
