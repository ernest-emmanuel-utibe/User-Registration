
package com.secure.userRegAndAuthSys.controller.registration;

import com.secure.userRegAndAuthSys.data.models.User;
import com.secure.userRegAndAuthSys.event.RegistrationCompleteEvent;
import com.secure.userRegAndAuthSys.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
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
    
    // Inject the application event publisher interface
    private final ApplicationEventPublisher applicationEventPublisher;

    @PostMapping("/register")
    public String registerUser(RegistrationRequest registrationRequest, final HttpServletRequest httpServletRequest) {
        
        User user = userService.registerUser(registrationRequest);

        //publish registration event
        applicationEventPublisher.publishEvent(new RegistrationCompleteEvent(user, applicationUrl(httpServletRequest)));

        return "Successfully registered. AN email has been sent to you for further confirmation, please check.";
    }

    public String applicationUrl(HttpServletRequest httpServletRequest) {
        
        // return the name of the URL you will be building. Get the server name, port and the actual context.
        return "http://" + httpServletRequest.getServerName() + ":" + httpServletRequest.getServerPort() +
                httpServletRequest.getContextPath();

    }
}
