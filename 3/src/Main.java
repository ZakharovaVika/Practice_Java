//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Random;
public class Main {
    public static void main(String[] args) {
// Пример использования
        Random random = new Random();
        EconomyRoom economyRoom = new EconomyRoom(101);
        StandardRoom standardRoom = new StandardRoom(201, 2);
        LuxRoom luxRoom = new LuxRoom(301, 4);
        UltraLuxRoom ultraLuxRoom = new UltraLuxRoom(401, 6);

        SimpleRoomService roomService = new SimpleRoomService();

        System.out.println("Исходное состояние комнат:");
        System.out.println(economyRoom);
        System.out.println(standardRoom);
        System.out.println(luxRoom);
        System.out.println(ultraLuxRoom);

        // Бронируем комнату
        try {
            roomService.reserve(economyRoom);
        } catch (RoomAlreadyReservedException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        // Пытаемся забронировать комнату снова (должно вызвать исключение)
        try {
            roomService.reserve(economyRoom);
        } catch (RoomAlreadyReservedException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        // Освобождаем комнату
        roomService.free(economyRoom);

        // Бронируем и освобождаем другие комнаты
        roomService.reserve(standardRoom);
        roomService.clean(standardRoom);
        roomService.free(standardRoom);

        roomService.reserve(luxRoom);
        roomService.clean(luxRoom);
        roomService.free(luxRoom);

        roomService.reserve(ultraLuxRoom);
        roomService.clean(ultraLuxRoom);
        roomService.free(ultraLuxRoom);


        System.out.println("\nСостояние комнат после операций:");
        System.out.println(economyRoom);
        System.out.println(standardRoom);
        System.out.println(luxRoom);
        System.out.println(ultraLuxRoom);
    }
}