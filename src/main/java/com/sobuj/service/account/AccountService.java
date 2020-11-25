package com.sobuj.service.account;

import com.sobuj.dto.AccountCreateDto;
import com.sobuj.dto.AccountUpdateDto;
import com.sobuj.dto.VerifyAccountDto;
import com.sobuj.models.Account;

import java.util.List;
import java.util.Optional;

public interface AccountService{
    Account registration(AccountCreateDto accountDto) throws Exception;

    Account updateAccount(AccountUpdateDto updateDto) throws Exception;

    void verifyCode(VerifyAccountDto codeVerifyDto);

    Optional<Account> findByEmail(String email);

    Optional<Account> findById(Long id);

    List<Account> findAll();

    void delete(Long id);
}
