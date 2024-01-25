package com.secure.userRegAndAuthSys.service;

import com.secure.userRegAndAuthSys.controller.registration.RegistrationRequest;
import com.secure.userRegAndAuthSys.data.models.User;
import java.util.List;
import java.util.Optional;

/**
 * @author Ernest Emmanuel Utibe
 */

public interface UserService {
    User registerUser(RegistrationRequest registrationRequest);
    List<User> getRegisteredUsers();
    Optional<User> findByEmail(String email);

    void saveUserVerificationToken(User theUser, String verificationToken);
}
