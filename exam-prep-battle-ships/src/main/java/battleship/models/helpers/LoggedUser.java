package battleship.models.helpers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LoggedUser {
    private Long id;

    public boolean isUserLogged(){
        return this.id != null;
    }

    public void clearUser(){
        this.id = null;
    }
}
