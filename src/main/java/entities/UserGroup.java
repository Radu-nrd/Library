package entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

public class UserGroup {
    private Long id;
    private String username;
    private String role;
@Id
@GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
