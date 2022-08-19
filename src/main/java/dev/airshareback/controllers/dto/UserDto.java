package dev.airshareback.controllers.dto;

import javax.validation.constraints.Email;
import java.io.Serializable;

public class UserDto implements Serializable {
    private final String pseudo;
    private final String firstName;
    private final String lastName;
    @Email
    private final String mailAddress;
    private final String password;
    private final String role;

    public UserDto(String pseudo, String firstName, String lastName, String mailAddress, String password, String role) {
        this.pseudo = pseudo;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mailAddress = mailAddress;
        this.password = password;
        this.role = role;
    }
    public String getPseudo() {
        return pseudo;
    }
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMailAddress() {
        return mailAddress;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }
}
