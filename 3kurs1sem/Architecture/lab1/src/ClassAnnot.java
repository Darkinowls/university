import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = ElementType.TYPE) // Class
@Retention(value = RetentionPolicy.RUNTIME)

public @interface ClassAnnot {

    String name();
    String desc() default "";
}
