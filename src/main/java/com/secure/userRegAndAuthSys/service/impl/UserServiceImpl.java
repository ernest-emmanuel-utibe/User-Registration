package com.secure.userRegAndAuthSys.service.impl;

import com.secure.userRegAndAuthSys.controller.registration.RegistrationRequest;
import com.secure.userRegAndAuthSys.data.models.User;
import com.secure.userRegAndAuthSys.data.repository.UserRepository;
import com.secure.userRegAndAuthSys.event.token.VerificationToken;
import com.secure.userRegAndAuthSys.event.token.VerificationTokenRepository;
import com.secure.userRegAndAuthSys.exception.UserAlreadyExistsException;
import com.secure.userRegAndAuthSys.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


/**
 * @author Ernest Emmanuel Utibe
 */

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final VerificationTokenRepository verificationTokenRepository;
    @Override
    public User registerUser(RegistrationRequest registrationRequest) {
        // Check if the user email is already in existence in the database
        Optional<User> user = this.findByEmail(registrationRequest.email());
        // Check if the user exist or not.
        if (user.isPresent()) {
            // Throw in an exception if the user email exists
            throw new UserAlreadyExistsException("User with email " + registrationRequest.email() + " already exists");
        }
        // If the user is not in existence, continue registration of the user
        var newUser = new User();
        newUser.setFirstName(registrationRequest.firstName());
        newUser.setLastName(registrationRequest.lastName());
        newUser.setEmail(registrationRequest.email());
        newUser.setPassword(passwordEncoder.encode(registrationRequest.password()));
        newUser.setRole(registrationRequest.role());
        // Save the user information into the database
        return userRepository.save(newUser);
    }

    @Override
    public List<User> getRegisteredUsers() {
        // Return all the registered users
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findByEmail(String email) {
        // Find the user by their email
        return userRepository.findByEmail(email);
    }

    @Override
    public void saveUserVerificationToken(User theUser, String token) {
        var theVerificationToken = new VerificationToken(token, theUser);
        verificationTokenRepository.save(theVerificationToken);
    }
}
