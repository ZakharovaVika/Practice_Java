package annotations;

import java.lang.annotation.*;

// Определение аннотации @JsonField
@Retention(RetentionPolicy.RUNTIME) // Доступна во время выполнения
@Target(ElementType.FIELD)        // Может применяться только к полям
public @interface JsonField {
    String name();
}
