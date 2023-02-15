package battleship.validations.checkUserExistance;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Constraint(validatedBy = UserLoginFormValidator.class)
public @interface ValidateLoginForm {
    String message() default "Bad credentials!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
