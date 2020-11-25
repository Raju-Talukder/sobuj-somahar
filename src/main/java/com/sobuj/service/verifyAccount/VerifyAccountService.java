package com.sobuj.service.verifyAccount;

import com.sobuj.models.VerifyAccount;

import java.util.Optional;

public interface VerifyAccountService {
    VerifyAccount create(VerifyAccount verifyAccount);
    Optional<VerifyAccount> findByToken(String token);
    Optional<VerifyAccount> findById(Long id);
}
