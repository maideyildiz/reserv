package com.maide.reserv.registration;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class RegistrationRequest {
    private final String name;
    private final String surname;
    private final String password;
    private final Long phone;
    private final String email;
}
