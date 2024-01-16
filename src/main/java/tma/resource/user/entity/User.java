package tma.resource.user.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import tma.resource.user.dto.UserDTO;

@Table("users")
public class User {

    @Id
    private String username;

    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
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

    public UserDTO toDTO() {
        return new UserDTO(
            this.username,
            this.password
        );
    }
}
