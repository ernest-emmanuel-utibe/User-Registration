package com.secure.userRegAndAuthSys.data.repository;

import com.secure.userRegAndAuthSys.data.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
