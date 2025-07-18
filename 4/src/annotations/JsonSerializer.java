package annotations;

import java.lang.reflect.*;
import java.util.Map;
import java.util.HashMap;

public class JsonSerializer {
    public String toJson(Object obj) throws IllegalAccessException {
        if (obj == null) {
            return "null";
        }

        Class<?> clazz = obj.getClass();
        Map<String, Object> jsonMap = new HashMap<>();

        // Получаем все поля класса, включая приватные
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            // Проверяем, есть ли аннотация @JsonField на поле
            if (field.isAnnotationPresent(JsonField.class)) {
                JsonField jsonAnnotation = field.getAnnotation(JsonField.class);
                String jsonFieldName = jsonAnnotation.name();

                // Делаем поле доступным, даже если оно private
                field.setAccessible(true);
                Object fieldValue = field.get(obj);

                // Добавляем в мапу для формирования JSON
                // Обработка null значений для строковых полей
                if (fieldValue == null) {
                    jsonMap.put(jsonFieldName, null);
                } else {
                    // Простая сериализация: строка, число, булево.
                    // Для более сложных типов (списки, другие объекты) потребуется рекурсивная сериализация.
                    jsonMap.put(jsonFieldName, fieldValue);
                }
            }
        }

        // Формируем строку JSON
        StringBuilder jsonBuilder = new StringBuilder("{");
        boolean first = true;
        for (Map.Entry<String, Object> entry : jsonMap.entrySet()) {
            if (!first) {
                jsonBuilder.append(", ");
            }
            jsonBuilder.append("\"").append(entry.getKey()).append("\": ");
            Object value = entry.getValue();
            if (value instanceof String) {
                // Оборачиваем строки в кавычки
                jsonBuilder.append("\"").append(value).append("\"");
            } else {
                // Для чисел, булевых и null значений
                jsonBuilder.append(value);
            }
            first = false;
        }
        jsonBuilder.append("}");

        return jsonBuilder.toString();
    }
}
