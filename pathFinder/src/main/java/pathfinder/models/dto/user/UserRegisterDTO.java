package pathfinder.models.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class UserRegisterDTO {
    @NotEmpty
    @Size(min = 5, max = 45)
    private String username;
    @NotEmpty
    @Size(min = 5, max = 45)
    @Email
    private String email;
    @NotEmpty
    @Size(min = 8, max = 45)
    private String password;
    @NotEmpty
    @Size(min = 8, max = 45)
    private String rePassword;

    public UserRegisterDTO() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRePassword() {
        return rePassword;
    }

    public void setRePassword(String rePassword) {
        this.rePassword = rePassword;
    }
}
