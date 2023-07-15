package com.secure.userRegAndAuthSys.controller.registration;

import org.hibernate.annotations.NaturalId;

/**
 * @author Ernest Emmanuel Utibe
 */
public record RegistrationRequest(
        String firstName,
        String lastName,
        String email,
        String password,
        String role
        ) {
}
