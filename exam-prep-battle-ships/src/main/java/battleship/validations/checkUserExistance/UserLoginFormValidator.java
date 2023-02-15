package battleship.validations.checkUserExistance;

import battleship.models.binding.UserLoginModel;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UserLoginFormValidator implements ConstraintValidator<ValidateLoginForm,UserLoginModel> {

    @Override
    public void initialize(ValidateLoginForm constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(UserLoginModel userLoginModel, ConstraintValidatorContext context) {
        return false;
    }
}
