package com.home.domain;

import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.validation.constraints.Size;

@Data
//TODO: add check for matching password
public class UserDto {
    @NotEmpty(message = "Field should not be an empty")
    @Size(min = 3, max = 6, message = "Error in size")
    private String name;
    @NotEmpty(message = "Field should not be an empty")
    @Email(message = "Email is not valid")
    private String email;
    @NotEmpty(message = "Field should not be an empty")
    @Size(min = 6, max = 10, message = "Error in size")
    private String password;
    @NotEmpty(message = "Field should not be an empty")
    @Size(min = 6, max = 10, message = "Error in size")
    private String password_again;
}