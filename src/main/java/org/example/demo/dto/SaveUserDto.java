package org.example.demo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public class SaveUserDto {
    @Email(message = "Email must be valid")
    private String email;

    @NotEmpty
    private String password;

    public @Email(message = "Email must be valid") String getEmail() {
        return email;
    }

    public void setEmail(@Email(message = "Email must be valid") String email) {
        this.email = email;
    }

    public @NotEmpty String getPassword() {
        return password;
    }

    public void setPassword(@NotEmpty String password) {
        this.password = password;
    }
}
