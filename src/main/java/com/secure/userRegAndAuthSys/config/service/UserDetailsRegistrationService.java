package com.secure.userRegAndAuthSys.config.service;

import com.secure.userRegAndAuthSys.config.UserRegistrationDetails;
import com.secure.userRegAndAuthSys.data.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author Ernest Emmanuel Utibe
 **/

@Service
@RequiredArgsConstructor
public class UserDetailsRegistrationService implements UserDetailsService {
    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email)
                .map(UserRegistrationDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("Username not found"));
    }
}
