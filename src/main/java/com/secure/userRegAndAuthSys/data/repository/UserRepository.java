package com.secure.userRegAndAuthSys.data.repository;

import com.secure.userRegAndAuthSys.data.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


/**
 * @author Ernest Emmanuel Utibe
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
}
