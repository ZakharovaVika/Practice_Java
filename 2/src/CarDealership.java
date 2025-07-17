import java.util.*;
import java.util.stream.Collectors;
public class CarDealership {
    private List<Car> cars;

    public CarDealership() {
        this.cars = new ArrayList<>();
    }

    // 1. Добавить машину в автоцентр (проверять дубликаты по VIN).
    public boolean addCar(Car car) {
        if (cars.stream().anyMatch(c -> c.getVin().equals(car.getVin()))) {
            System.out.println("Автомобиль с VIN " + car.getVin() + " уже существует.");
            return false;
        }
        return cars.add(car);
    }

    // 2. Найти все машины указанного производителя (использовать Stream).
    public List<Car> findCarsByManufacturer(String manufacturer) {
        return cars.stream()
                .filter(car -> car.getManufacturer().equalsIgnoreCase(manufacturer))
                .collect(Collectors.toList());
    }

    // 3. Вывести среднюю цену машин определённого типа (SUV, ELECTRIC и др.).
    public OptionalDouble getAveragePriceByType(CarType type) {
        return cars.stream()
                .filter(car -> car.getType() == type)
                .mapToDouble(Car::getPrice)
                .average();
    }

    // 4. Вернуть список машин, отсортированных по году выпуска (от новых к старым).
    public List<Car> getCarsSortedByYear() {
        return cars.stream()
                .sorted(Comparator.comparingInt(Car::getYear).reversed())
                .collect(Collectors.toList());
    }
}
