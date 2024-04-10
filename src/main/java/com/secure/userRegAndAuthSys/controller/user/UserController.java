package com.secure.userRegAndAuthSys.controller.user;

import com.secure.userRegAndAuthSys.data.models.User;
import com.secure.userRegAndAuthSys.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Ernest Emmanuel Utibe
 **/


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {
    // Inject the user service class
    private final UserService userService;

    @GetMapping("/get_all_users")
    public List<User> getAllRegisteredUsers() {
        return userService.getRegisteredUsers();
    }
}
