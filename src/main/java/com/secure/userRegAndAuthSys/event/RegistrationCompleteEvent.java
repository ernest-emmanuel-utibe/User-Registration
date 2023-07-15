package com.secure.userRegAndAuthSys.event;

import com.secure.userRegAndAuthSys.data.models.User;
import lombok.*;
import org.springframework.context.ApplicationEvent;

/**
 * @author Ernest Emmanuel Utibe
 */

@Setter
@Getter
public class RegistrationCompleteEvent extends ApplicationEvent {
    private User user;
    private String applicationUrl;

    public RegistrationCompleteEvent(User user, String applicationUrl) {
        super(user);
        this.user = user;
        this.applicationUrl = applicationUrl;
    }
}
