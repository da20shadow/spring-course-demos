package pathfinder.models.entity;

import jakarta.persistence.*;
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
    @Enumerated(EnumType.STRING)
    private Role role;
    @Enumerated(EnumType.STRING)
    private LEVEL level;

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public Role getRole() {
        return role;
    }

    public User setRole(Role role) {
        this.role = role;
        return this;
    }

    public LEVEL getLevel() {
        return level;
    }

    public User setLevel(LEVEL level) {
        this.level = level;
        return this;
    }
}
