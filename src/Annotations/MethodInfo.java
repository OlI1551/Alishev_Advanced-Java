package Annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME) // в библиотеке пользователя мы получаем доступ к аннотациям через рефлексию
// поэтому нам нужно, чтобы доступ к аннотации сохранялся во время работы программы
public @interface MethodInfo {
    String author() default "Neil";
    int dateOfCreation() default 2019;
    String purpose();
}
