package entity;

import dto.Car;
import dto.Slot;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@Data
public class CarRepository {

    public static Map<String, List<Car>> colorVsCar;

    public static Map<String, Car> registrationIdVsCar;
}
