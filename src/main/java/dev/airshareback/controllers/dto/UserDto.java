package dev.airshareback.controllers.dto;

import javax.validation.constraints.Email;
import java.io.Serializable;

public class UserDto implements Serializable {
    private final String first_name;
    private final String last_name;
    @Email
    private final String mail_address;
    private final String password;

    private final String role;
    private final String status;
    private final String moderationStatus;

    public UserDto(String first_name, String last_name, String mail_address, String password, String role, String status, String moderationStatus) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.mail_address = mail_address;
        this.password = password;
        this.role = role;
        this.status = status;
        this.moderationStatus = moderationStatus;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getMail_address() {
        return mail_address;
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
