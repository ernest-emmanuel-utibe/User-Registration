package com.secure.userRegAndAuthSys.event.listener;

import com.secure.userRegAndAuthSys.data.models.User;
import com.secure.userRegAndAuthSys.event.RegistrationCompleteEvent;
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
    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event) {
        // Get the newly registered users
        User theNewlyRegisteredUser = event.getUser();
        // Create the verification Token for the user
        String verificationToken = UUID.randomUUID().toString();
        // Save the verification token for the user

        // Build the verification URl to be sent to the use4r
        String url = event.getApplicationUrl() + "/register/verifyEmail?token=" + verificationToken;
        // Send the email
        log.info("Click the link to verify yor email {}", url);

    }
}
