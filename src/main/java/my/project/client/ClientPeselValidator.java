package my.project.client;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
@Retention(RUNTIME)
@Constraint(validatedBy = ClientPeselValidation.class)
public @interface ClientPeselValidator {
    String message() default "niepoprawny numer pesel";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
