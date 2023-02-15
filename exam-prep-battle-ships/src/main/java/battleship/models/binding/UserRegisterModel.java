package battleship.models.binding;

import battleship.validations.passwordMatcher.PasswordMatch;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@PasswordMatch
public class UserRegisterModel {

    @Size(min = 3,max = 10) @NotNull
    private String username;

    @Size(min = 5,max = 20) @NotNull
    private String fullName;

    @Email @NotNull
    private String email;

    @Size(min = 8) @NotNull
    private String password;

    @Size(min = 8) @NotNull
    private String confirmPassword;
}
