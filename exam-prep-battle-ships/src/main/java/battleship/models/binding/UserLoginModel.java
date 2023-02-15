package battleship.models.binding;

import battleship.validations.checkUserExistance.ValidateLoginForm;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@ValidateLoginForm
public class UserLoginModel {
    @Size(min = 3,max = 10) @NotNull
    private String username;
    @Size(min = 8) @NotNull
    private String password;
}
