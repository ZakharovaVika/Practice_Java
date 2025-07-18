package annotations;
import java.lang.annotation.*;


@Retention(RetentionPolicy.RUNTIME) // Аннотация доступна во время выполнения
@Target({ElementType.TYPE, ElementType.METHOD}) // Может применяться к классам и методам
public @interface DeprecatedEx {
    String message();
}
