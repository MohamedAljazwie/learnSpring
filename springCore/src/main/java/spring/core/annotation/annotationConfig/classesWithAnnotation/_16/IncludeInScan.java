package spring.core.annotation.annotationConfig.classesWithAnnotation._16;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface IncludeInScan {
    String value() default "";
}
