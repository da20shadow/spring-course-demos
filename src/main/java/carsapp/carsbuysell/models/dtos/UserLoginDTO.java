package carsapp.carsbuysell.models.dtos;

import jakarta.validation.constraints.NotEmpty;

public class UserLoginDTO {

    @NotEmpty
    private String username;
    @NotEmpty
    private String password;

    public UserLoginDTO() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
