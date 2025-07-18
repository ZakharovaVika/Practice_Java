package annotations;

import java.lang.reflect.*;

public class DeprecatedExHandler {
    public static void checkDeprecatedElements(Class<?> clazz) {
        System.out.println("--- Обработка аннотации @DeprecatedEx для класса: " + clazz.getName() + " ---");

        // Проверка аннотации на классе
        if (clazz.isAnnotationPresent(DeprecatedEx.class)) {
            DeprecatedEx annotation = clazz.getAnnotation(DeprecatedEx.class);
            System.out.println("Внимание: класс '" + clazz.getSimpleName() + "' устарел. Альтернатива: '" + annotation.message() + "'");
        }

        // Проверка аннотаций на методах
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(DeprecatedEx.class)) {
                DeprecatedEx annotation = method.getAnnotation(DeprecatedEx.class);
                System.out.println("Внимание: метод '" + method.getName() + "' устарел. Альтернатива: '" + annotation.message() + "'");
            }
        }
        System.out.println("-----------------------------------------------------------\n");
    }
}
