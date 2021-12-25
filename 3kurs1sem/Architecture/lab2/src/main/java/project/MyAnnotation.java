package project;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//@Target(value= ElementType.FIELD)
//@Retention(value = RetentionPolicy.SOURCE)

@Target(value=ElementType.METHOD)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
    String name();
    String returns () default "" ;
}
