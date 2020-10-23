package com.sobuj.service.account;

import com.sobuj.dto.AccountCreateDto;
import com.sobuj.dto.VerifyAccountDto;
import com.sobuj.models.Account;

import java.util.List;
import java.util.Optional;

public interface AccountService{
    Account createMember(AccountCreateDto accountDto) throws Exception;

    Account createUserByAdmin(AccountCreateDto accountDto);

    void verifyCode(VerifyAccountDto codeVerifyDto);

    Optional<Account> findByEmail(String email);

    Optional<Account> findById(Long id);

    List<Account> findAll();

    void delete(Long id);
}
