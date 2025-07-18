package lambda;

import annotations.DeprecatedExHandler;
import annotations.JsonSerializer;
import model.HeavyBox;
import model.User;

import java.util.function.Predicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.Random;

public class LambdaDemo {
    public static void main(String[] args) throws Exception {
        // --- Демонстрация задания 1: Лямбда для Printable ---
        System.out.println("--- Задание 1: Лямбда для Printable ---");
        Printable printer = () -> System.out.println("Это сообщение от лямбда-выражения!");
        printer.print();
        System.out.println("-----------------------------------------\n");

        // --- Демонстрация задания 2: Проверка пустой строки ---
        System.out.println("--- Задание 2: Проверка пустой строки ---");
        Predicate<String> isNotNull = s -> s != null;
        Predicate<String> isNotEmpty = s -> !s.isEmpty();
        Predicate<String> isNotNullAndNotEmpty = isNotNull.and(isNotEmpty);

        String str1 = "Привет";
        String str2 = "";
        String str3 = null;
        String str4 = " "; // Строка с пробелом

        System.out.println("Проверка '" + str1 + "': " + isNotNullAndNotEmpty.test(str1)); // true
        System.out.println("Проверка '" + str2 + "': " + isNotNullAndNotEmpty.test(str2)); // false
        System.out.println("Проверка '" + str3 + "': " + isNotNullAndNotEmpty.test(str3)); // false
        System.out.println("Проверка '" + str4 + "': " + isNotNullAndNotEmpty.test(str4)); // true (если пробел считается непустой)
        System.out.println("-----------------------------------------\n");

        // --- Демонстрация задания 3: Проверка строки ---
        System.out.println("--- Задание 3: Проверка строки ---");
        // Условие: начинается с 'J' или 'N' И заканчивается на 'A'
        Predicate<String> startsWithJorN = s -> s != null && (s.startsWith("J") || s.startsWith("N"));
        Predicate<String> endsWithA = s -> s != null && s.endsWith("A");
        Predicate<String> complexStringCheck = startsWithJorN.and(endsWithA);

        String testStr1 = "Java";
        String testStr2 = "NodeA";
        String testStr3 = "JavaScript";
        String testStr4 = "Python";
        String testStr5 = "j"; // Не заканчивается на A

        System.out.println("Проверка '" + testStr1 + "': " + complexStringCheck.test(testStr1)); // true
        System.out.println("Проверка '" + testStr2 + "': " + complexStringCheck.test(testStr2)); // true
        System.out.println("Проверка '" + testStr3 + "': " + complexStringCheck.test(testStr3)); // false (не заканчивается на A)
        System.out.println("Проверка '" + testStr4 + "': " + complexStringCheck.test(testStr4)); // false (не начинается с J/N)
        System.out.println("Проверка '" + testStr5 + "': " + complexStringCheck.test(testStr5)); // false (не заканчивается на A)
        System.out.println("-----------------------------------------\n");

        // --- Демонстрация задания 4: Лямбда для HeavyBox ---
        System.out.println("--- Задание 4: Лямбда для HeavyBox ---");
        HeavyBox box1 = new HeavyBox(150);
        HeavyBox box2 = new HeavyBox(200);

        Consumer<HeavyBox> dispatchAction = box -> System.out.println("Отгрузили ящик с весом " + box.getWeight());
        Consumer<HeavyBox> shipAction = box -> System.out.println("Отправляем ящик с весом " + box.getWeight());

        Consumer<HeavyBox> combinedAction = dispatchAction.andThen(shipAction);

        combinedAction.accept(box1);
        System.out.println("---");
        combinedAction.accept(box2);
        System.out.println("-----------------------------------------\n");

        // --- Демонстрация задания 5: Лямбда для Function ---
        System.out.println("--- Задание 5: Лямбда для Function ---");
        Function<Integer, String> numberClassifier = num -> {
            if (num > 0) {
                return "Положительное число";
            } else if (num < 0) {
                return "Отрицательное число";
            } else {
                return "Ноль";
            }
        };

        System.out.println("Классификация 10: " + numberClassifier.apply(10));
        System.out.println("Классификация -5: " + numberClassifier.apply(-5));
        System.out.println("Классификация 0: " + numberClassifier.apply(0));
        System.out.println("-----------------------------------------\n");

        // --- Демонстрация задания 6: Лямбда для Supplier ---
        System.out.println("--- Задание 6: Лямбда для Supplier ---");
        Supplier<Integer> randomIntSupplier = () -> new Random().nextInt(11); // nextInt(11) дает числа от 0 до 10

        System.out.println("Случайное число: " + randomIntSupplier.get());
        System.out.println("Случайное число: " + randomIntSupplier.get());
        System.out.println("-----------------------------------------\n");


        // --- Демонстрация работы с аннотациями и рефлексией ---

        // Демонстрация Задания 1: Обработчик @DeprecatedEx
        DeprecatedExHandler.checkDeprecatedElements(model.OldCustomerService.class);


        // Демонстрация Задания 2: Сериализация в JSON
        System.out.println("--- Демонстрация Задания 2: Сериализация в JSON ---");
        User user = new User(1, "Alice", "alice@example.com");
        JsonSerializer serializer = new JsonSerializer();
        String userJson = serializer.toJson(user);
        System.out.println("Объект User: " + user); // Вывод объекта User
        System.out.println("JSON представление: " + userJson);


        System.out.println("----------------------------------------------------\n");
    }
}
