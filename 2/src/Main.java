import java.util.*;
import java.util.stream.Collectors;
public class Main {
    public static void main(String[] args) {

        //-----------------------------------------------------------------------------------------
        int[] carYears = new int[50];
        Random random = new Random();

        for (int i = 0; i < carYears.length; i++) {
            carYears[i] = 2000 + random.nextInt(26); // Генерация случайного года от 2000 до 2025 включительно
        }

        System.out.println("Массив годов выпуска автомобилей: " + Arrays.toString(carYears));

        // 2. Выведите только машины, выпущенные после 2015 года.
        System.out.println("\nАвтомобили, выпущенные после 2015 года:");
        for (int year : carYears) {
            if (year > 2015) {
                System.out.println(year);
            }
        }

        // 3. Посчитайте средний возраст авто.
        int currentYear = java.time.Year.now().getValue(); // Получаем текущий год
        int totalAge = 0;
        for (int year : carYears) {
            totalAge += currentYear - year; // Рассчитываем возраст каждой машины и добавляем к общей сумме
        }

        double averageAge = (double) totalAge / carYears.length; // Вычисляем средний возраст
        System.out.println("\nСредний возраст автомобилей в парке: " + averageAge + " лет.");

        //--------------------------------------------------------------------------------------------
        // 1. Создайте список с названиями моделей машин (например: Toyota Camry, BMW X5).
        List<String> carModels = new ArrayList<>();
        carModels.add("Toyota Camry");
        carModels.add("BMW X5");
        carModels.add("Mercedes-Benz C-Class");
        carModels.add("Toyota Camry"); // Добавляем дубликат
        carModels.add("Tesla Model S");
        carModels.add("Audi A4");
        carModels.add("BMW X5"); // Еще один дубликат
        carModels.add("Tesla Model 3");
        carModels.add("Ford Mustang");

        System.out.println("Исходный список моделей: " + carModels);

        // 2. Удалите дубликаты, затем отсортируйте модели в обратном алфавитном порядке, выведите на экран, затем сохраните в Set.

        // Удаление дубликатов с использованием Set
        Set<String> uniqueCarModels = new HashSet<>(carModels);
        carModels = new ArrayList<>(uniqueCarModels); // Преобразуем Set обратно в List

        // Сортировка в обратном алфавитном порядке
        Collections.sort(carModels, Collections.reverseOrder());

        System.out.println("\nСписок моделей после удаления дубликатов и сортировки в обратном порядке: " + carModels);


        // 3. Реализуйте проверку: если модель содержит слово "Tesla", замените её на "ELECTRO_CAR".
        for (int i = 0; i < carModels.size(); i++) {  // Итерируем по списку по индексу, так как нужно заменить элемент
            if (carModels.get(i).contains("Tesla")) {
                carModels.set(i, "ELECTRO_CAR");  // Заменяем "Tesla" на "ELECTRO_CAR"
            }
        }

        System.out.println("\nСписок моделей после замены 'Tesla' на 'ELECTRO_CAR': " + carModels);


        //-------------------------------------------------------------------------------------------------------------
        // Создание нескольких объектов Car
        Car car1 = new Car("VIN123", "Camry", "Toyota", 2022, 50000, 25000.0, CarType.SEDAN);
        Car car2 = new Car("VIN456", "X5", "BMW", 2021, 75000, 60000.0, CarType.SEDAN);
        Car car3 = new Car("VIN123", "Corolla", "Toyota", 2020, 100000, 18000.0, CarType.SEDAN); // Дубликат по VIN с car1
        Car car4 = new Car("VIN789", "A4", "Audi", 2023, 25000, 45000.0, CarType.SEDAN);
        Car car5 = new Car("VIN456", "X5", "BMW", 2021, 75000, 60000.0, CarType.SEDAN); // Дубликат по VIN с car2
        Car car6 = new Car("VIN000", "Focus", "Ford", 2018, 120000, 12000.0, CarType.SEDAN);

        // Добавление машин в HashSet
        Set<Car> carSet = new HashSet<>();
        carSet.add(car1);
        carSet.add(car2);
        carSet.add(car3); // Не должен добавиться (дубликат по VIN)
        carSet.add(car4);
        carSet.add(car5); // Не должен добавиться (дубликат по VIN)
        carSet.add(car6);

        // Вывод содержимого HashSet (дубликаты по VIN не добавляются)
        System.out.println("HashSet с машинами (дубликаты по VIN не добавляются):");
        for (Car car : carSet) {
            System.out.println(car);
        }

        // Создание TreeSet для сортировки машин по году выпуска
        TreeSet<Car> sortedCars = new TreeSet<>();
        sortedCars.addAll(carSet); // Добавляем все элементы из HashSet в TreeSet (автоматическая сортировка)

        // Вывод отсортированного TreeSet
        System.out.println("\nTreeSet с машинами, отсортированными по году выпуска (от новых к старым):");
        for (Car car : sortedCars) {
            System.out.println(car);
        }


        //--------------------------------------------------------------------------------------------------------------
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("VIN001", "Camry", "Toyota", 2020, 60000, 25000.0, CarType.SEDAN));
        carList.add(new Car("VIN002", "X5", "BMW", 2021, 45000, 60000.0, CarType.SEDAN));
        carList.add(new Car("VIN003", "Model S", "Tesla", 2022, 25000, 80000.0, CarType.SEDAN));
        carList.add(new Car("VIN004", "A4", "Audi", 2019, 70000, 40000.0, CarType.SEDAN));
        carList.add(new Car("VIN005", "Mustang", "Ford", 2023, 15000, 35000.0, CarType.SEDAN));
        carList.add(new Car("VIN006", "Model 3", "Tesla", 2022, 30000, 55000.0, CarType.SEDAN));
        carList.add(new Car("VIN007", "CR-V", "Honda", 2021, 55000, 30000.0, CarType.SEDAN));

        // 2. Отфильтруйте только машины с пробегом меньше 50_000 км (добавьте поле mileage).
        List<Car> lowMileageCars = carList.stream()
                .filter(car -> car.getMileage() < 50000)
                .collect(Collectors.toList());

        System.out.println("Машины с пробегом меньше 50_000 км:");
        lowMileageCars.forEach(System.out::println);

        // 3. Отсортируйте по цене (по убыванию).
        List<Car> sortedByPrice = carList.stream()
                .sorted(Comparator.comparingDouble(Car::getPrice).reversed())
                .collect(Collectors.toList());

        // 4. Выведите топ-3 самые дорогие машины.
        System.out.println("\nТоп-3 самые дорогие машины:");
        sortedByPrice.stream()
                .limit(3)
                .forEach(System.out::println);

        // 5. Посчитайте средний пробег всех машин.
        double averageMileage = carList.stream()
                .mapToInt(Car::getMileage)
                .average()
                .orElse(0); // Обработка случая, когда список машин пуст

        System.out.println("\nСредний пробег всех машин: " + averageMileage);

        // 6. Сгруппируйте машины по производителю в Map<String, List<Car>>.
        Map<String, List<Car>> carsByManufacturer = carList.stream()
                .collect(Collectors.groupingBy(Car::getManufacturer));

        System.out.println("\nМашины, сгруппированные по производителю:");
        carsByManufacturer.forEach((manufacturer, cars) -> {
            System.out.println("Производитель: " + manufacturer);
            cars.forEach(System.out::println);
        });


        //------------------------------------------------------------------------------------------------------------------
        CarDealership dealership = new CarDealership();
        Scanner scanner = new Scanner(System.in);

        // Пример добавления машин
        dealership.addCar(new Car("VIN123", "ModelA", "Toyota", 2020, 50000, 25000.0, CarType.SEDAN));
        dealership.addCar(new Car("VIN456", "ModelB", "Honda", 2022, 25000, 30000.0, CarType.SUV));
        dealership.addCar(new Car("VIN789", "ModelC", "Tesla", 2023, 10000, 50000.0, CarType.ELECTRIC));
        dealership.addCar(new Car("VIN012", "ModelD", "Toyota", 2018, 80000, 18000.0, CarType.SEDAN));
        dealership.addCar(new Car("VIN345", "ModelE", "BMW", 2021, 35000, 40000.0, CarType.SUV));


        while (true) {
            System.out.println("\nМеню:");
            System.out.println("1. Добавить машину");
            System.out.println("2. Найти машины по производителю");
            System.out.println("3. Вывести среднюю цену машин по типу");
            System.out.println("4. Вывести машины, отсортированные по году выпуска");
            System.out.println("5. Показать статистику");
            System.out.println("6. Выйти");

            System.out.print("Выберите действие: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Введите VIN: ");
                    String vin = scanner.nextLine();
                    System.out.print("Введите модель: ");
                    String model = scanner.nextLine();
                    System.out.print("Введите производителя: ");
                    String manufacturer = scanner.nextLine();
                    System.out.print("Введите год выпуска: ");
                    int year = scanner.nextInt();
                    System.out.print("Введите пробег: ");
                    int mileage = scanner.nextInt();
                    System.out.print("Введите цену: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline

                    System.out.println("Выберите тип автомобиля (SEDAN, SUV, ELECTRIC):");
                    String typeStr = scanner.nextLine().toUpperCase();
                    CarType type = null;
                    try {
                        type = CarType.valueOf(typeStr);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Некорректный тип автомобиля.  Автомобиль не будет добавлен.");
                        break;
                    }

                    Car newCar = new Car(vin, model, manufacturer, year, mileage, price, type);
                    if (dealership.addCar(newCar)) {
                        System.out.println("Автомобиль успешно добавлен.");
                    }
                    break;
                case 2:
                    System.out.print("Введите производителя: ");
                    String manufacturerToFind = scanner.nextLine();
                    List<Car> foundCars = dealership.findCarsByManufacturer(manufacturerToFind);
                    System.out.println("Найденные автомобили:");
                    for (Car car : foundCars) {
                        System.out.println(car); // Предполагается, что в классе Car переопределен метод toString()
                    }
                    break;
                case 3:
                    System.out.println("Выберите тип автомобиля (SEDAN, SUV, ELECTRIC):");
                    String typeForAvgPriceStr = scanner.nextLine().toUpperCase();
                    CarType typeForAvgPrice = null;
                    try {
                        typeForAvgPrice = CarType.valueOf(typeForAvgPriceStr);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Некорректный тип автомобиля.");
                        break;
                    }

                    OptionalDouble averagePrice = dealership.getAveragePriceByType(typeForAvgPrice);
                    if (averagePrice.isPresent()) {
                        System.out.println("Средняя цена автомобилей типа " + typeForAvgPrice + ": " + averagePrice.getAsDouble());
                    } else {
                        System.out.println("Нет автомобилей типа " + typeForAvgPrice + " в наличии.");
                    }
                    break;
                case 4:
                    List<Car> sortCars = dealership.getCarsSortedByYear();
                    System.out.println("Автомобили, отсортированные по году выпуска (от новых к старым):");
                    for (Car car : sortCars) {
                        System.out.println(car);
                    }
                    break;
                default:
                    System.out.println("Некорректный выбор. Попробуйте снова.");
            }

        }
    }

}