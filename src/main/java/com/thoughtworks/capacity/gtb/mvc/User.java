package com.thoughtworks.capacity.gtb.mvc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer id;
    @NotNull(message = "username must not be null")
    @Pattern(regexp = "[a-z0-9A-Z_]{3,10}", message = "username only letters, number and _, length : 3 - R10")

    private String username;
    @NotNull(message = "password must not be null")
    @Length(min = 5, max = 12)

    private String password;
    @Email
    private String email;
}

