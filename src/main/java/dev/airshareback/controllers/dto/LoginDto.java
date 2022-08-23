package dev.airshareback.controllers.dto;

import java.io.Serializable;

public class LoginDto implements Serializable {
    private final String pseudo;
    private final String password;

    public LoginDto(String pseudo, String password) {
        this.pseudo = pseudo;
        this.password = password;
    }

    public String getPseudo() {
        return pseudo;
    }

    public String getPassword() {
        return password;
    }
}
