package com.secure.userRegAndAuthSys.event.token;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Ernest Emmanuel Utibe
 * */

public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Long> {
}
