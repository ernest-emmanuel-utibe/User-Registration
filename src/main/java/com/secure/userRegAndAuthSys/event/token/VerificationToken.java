package com.secure.userRegAndAuthSys.event.token;

import com.secure.userRegAndAuthSys.data.models.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.Calendar;
import java.util.Date;

/*
  *  @author Ernest Emmanuel Utibe
*/
@Getter
@Setter
@Entity
@NoArgsConstructor
public class VerificationToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String token;
    private Date expirationTime;
    private static final int EXPIRATION_TIME = 15;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public VerificationToken(String token, User user) {
        super();
        this.token = token;
        this.user = user;
        this.expirationTime = this.getTokenExpirationTime();
    }

    public VerificationToken(String token) {
        super();
        this.token = token;
        this.expirationTime = this.getTokenExpirationTime();
    }

    // Create a method *getTokenExpirationTime* to calculate how token.
    public Date getTokenExpirationTime() {
        // Create a calendar object and get the instance of that calendar object
        Calendar calendar = Calendar.getInstance();
        // Set the time to mili-seconds
        calendar.setTimeInMillis(new Date().getTime());
        // Add few seconds to the *calendar* variable
        calendar.add(Calendar.MINUTE, EXPIRATION_TIME);
        // Return the new date 
        return new Date(calendar.getTime().getTime());
    }
}
