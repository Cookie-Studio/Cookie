package top.cookie.event.listener;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface EventHandler {
    /** Choose form 1 to 10 */
    int priority() default 5;

    /** If ignore canceled event */
    boolean ignoreCancelled() default false;
}

