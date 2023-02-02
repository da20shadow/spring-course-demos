package pathfinder.models.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import pathfinder.models.enums.LEVEL;
import pathfinder.models.enums.Role;

@Entity
@Table(name = "users")
public class User extends BaseEntity {
    @Column
    private String username;
    @Column
    private String email;
    @Column
    private String password;
    @Enumerated
    private Role role;
    @Enumerated
    private LEVEL level;
}
