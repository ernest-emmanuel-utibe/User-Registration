package com.secure.userRegAndAuthSys.event.listener;

import com.secure.userRegAndAuthSys.data.models.User;
import com.secure.userRegAndAuthSys.event.RegistrationCompleteEvent;
import com.secure.userRegAndAuthSys.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.UUID;

/*
 *   @author Ernest Emmanuel Utibe
*/

@Slf4j
@Component
@RequiredArgsConstructor
public class RegistrationCompleteEventListener implements ApplicationListener<RegistrationCompleteEvent> {
    private final UserService userService;
    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event) {
        // Get the newly registered users
        User theNewlyRegisteredUser = event.getUser();
        
        // Create the verification Token for the user
        String verificationToken = UUID.randomUUID().toString();
        // Save the verification token for the user
        userService.saveUserVerificationToken(theNewlyRegisteredUser, verificationToken);
        // Build the verification URl to be sent to the user
        String url = event.getApplicationUrl() + "/register/verifyEmail?token=" + verificationToken;
        // Send the email
        log.info("Click the link to verify yor email {}", url);

    }
}
