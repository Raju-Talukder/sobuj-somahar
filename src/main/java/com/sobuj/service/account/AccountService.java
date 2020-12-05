package com.sobuj.service.account;

import com.sobuj.dto.AccountCreateDto;
import com.sobuj.dto.AccountUpdateDto;
import com.sobuj.dto.VerifyAccountDto;
import com.sobuj.models.Account;
import com.sobuj.service.address.AddressService;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface AccountService{
    Account registration(AccountCreateDto accountDto) throws Exception;

    Account updateAccount(MultipartFile image, AccountUpdateDto updateDto) throws Exception;

    void getProfileInfo(Model model, AccountService accountService, AddressService addressService);

    void showUserUpdateProfileFormData(Model model,AccountUpdateDto accountUpdateDto, AccountService accountService, AddressService addressService);

    void verifyCode(VerifyAccountDto codeVerifyDto);

    Optional<Account> findByEmail(String email);

    Optional<Account> findById(Long id);

    List<Account> findAll();

    void delete(Long id);
}
