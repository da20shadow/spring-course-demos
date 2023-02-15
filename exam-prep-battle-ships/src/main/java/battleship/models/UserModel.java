package battleship.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class UserModel {
    private String username;
    private String fullName;
    private String email;
    private String password;
}
