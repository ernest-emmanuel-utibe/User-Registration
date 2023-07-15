package com.secure.userRegAndAuthSys.controller.registration;

import com.secure.userRegAndAuthSys.data.models.User;
import com.secure.userRegAndAuthSys.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ernest Emmanuel Utibe
 */
@RestController
@RequestMapping("api/v1/user_registration")
@RequiredArgsConstructor
public class RegistrationController {
    // Inject the user service class
    private final UserService userService;

    @PostMapping("/register")
    public String registerUser(RegistrationRequest registrationRequest) {
        User user = userService.registerUser(registrationRequest);

        return "Successfully registered. AN email has been sent to you for further confirmation, please check.";
    }
}
