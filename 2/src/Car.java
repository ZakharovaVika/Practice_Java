import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
public class Car implements Comparable<Car> {



    private String vin;
    private String model;
    private String manufacturer;
    private int year;
    private int mileage;
    private double price;
    private CarType type;



    // Конструктор класса
    public Car(String vin, String model, String manufacturer, int year, int mileage, double price, CarType type) {
        this.vin = vin;
        this.model = model;
        this.manufacturer = manufacturer;
        this.year = year;
        this.mileage = mileage;
        this.type = type;

    }
    public String getManufacturer() {
        return manufacturer;
    }

    public int getMileage() {
        return mileage;
    }
    public double getPrice() {
        return price;
    }
    public int getYear() {
        return year;
    }
    public CarType getType() {
        return type;
    }
    public String getVin() {
        return vin;
    }



    // Переопределенный метод equals()
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // Ссылка на тот же объект
        if (obj == null || getClass() != obj.getClass()) return false; // Проверка на null и принадлежность к одному классу
        Car car = (Car) obj;
        return Objects.equals(vin, car.vin); // Сравнение только по VIN
    }

    // Переопределенный метод hashCode()
    @Override
    public int hashCode() {
        return Objects.hash(vin); // HashCode вычисляется только на основе VIN
    }
    // Переопределенный метод toString() для удобного вывода информации об автомобиле
    @Override
    public String toString() {
        return "Car{" +
                "vin='" + vin + '\'' +
                ", model='" + model + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", year=" + year +
                ", mileage=" + mileage +
                ", price=" + price +
                ", type=" + type +
                '}';
    }
    // Реализация интерфейса Comparable для сортировки по году выпуска (от новых к старым)
    @Override
    public int compareTo(Car otherCar) {
        return Integer.compare(otherCar.year, this.year); // Сравнение по году выпуска в обратном порядке (новые сначала)
    }




}
