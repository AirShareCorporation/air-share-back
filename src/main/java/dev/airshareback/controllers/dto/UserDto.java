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
    private final String status;
    private final String moderationStatus;

    public UserDto(String pseudo, String firstName, String lastName, String mailAddress,
                   String password, String role, String status, String moderationStatus) {
        this.pseudo = pseudo;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mailAddress = mailAddress;
        this.password = password;
        this.role = role;
        this.status = status;
        this.moderationStatus = moderationStatus;
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

    public String getStatus() {
        return status;
    }

    public String getModerationStatus() {
        return moderationStatus;
    }
}
