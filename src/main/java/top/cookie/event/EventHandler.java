package top.cookie.event;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface EventHandler {
    int priority() default PriorityType.MEDIUM;
    boolean IgnoreCanceled() default false;
}

interface PriorityType{
    int LOWEST = 1;
    int LOWER = 2;
    int LOW = 3;
    int MEDIUMLOW = 4;
    int MEDIUM = 5;
    int MEDIUMHIGH = 6;
    int HIGH = 7;
    int HIGHER = 8;
    int HIGHEST = 9;
}