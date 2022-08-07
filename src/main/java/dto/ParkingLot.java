package dto;

import lombok.Getter;
import lombok.Setter;
import strategy.NearestSlotFromEntry;
import strategy.ParkingStrategy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

@Getter
@Setter
public class ParkingLot {

    private int capacity;
    private ParkingStrategy parkingStrategy;
    private List<Car> parkedCars;

    private ParkingLot(int capacity) {
        this.capacity = capacity;
        parkingStrategy = new NearestSlotFromEntry(capacity);
        parkedCars = new ArrayList<>();
    }

    private static ParkingLot parkingLot;

    public static ParkingLot createInstance(int capacity) {
        if (parkingLot == null) {
            try {
                parkingLot = new ParkingLot(capacity);
            } catch (Exception e) {
                System.out.println("Failed to create parking lot with exception " + e.getMessage());
            }
        }
        return parkingLot;
    }

    public static ParkingLot getParkingLot() {
        return parkingLot;
    }
}
