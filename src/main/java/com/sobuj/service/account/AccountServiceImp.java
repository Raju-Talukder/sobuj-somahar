package com.sobuj.service.account;

import com.sobuj.dto.AccountCreateDto;
import com.sobuj.dto.AccountUpdateDto;
import com.sobuj.dto.VerifyAccountDto;
import com.sobuj.mail.Mail;
import com.sobuj.mail.MailService;
import com.sobuj.models.*;
import com.sobuj.repository.AccountRepository;
import com.sobuj.repository.VerifyAccountRepository;
import com.sobuj.service.role.RoleService;
import com.sobuj.utils.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class AccountServiceImp implements AccountService{
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private VerifyAccountRepository verifyAccountRepository;
    @Autowired
    private RoleService roleService;
    @Autowired
    private MailService mailService;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public Account registration(AccountCreateDto accountDto) throws Exception {
        Account account = new Account();
        account.setName(accountDto.getName());
        account.setPhone(accountDto.getPhone());
        account.setEmail(accountDto.getEmail());
        account.setPassword(passwordEncoder.encode(accountDto.getPassword()));
        if(roleService.findById(2l).isPresent()) {
            Role role = roleService.findById(2l).get();
            account.addRole(role);
        }

        String token = RandomUtils.generateRandomStringNumber(6).toUpperCase();

        VerifyAccount verifyAccount = new VerifyAccount();
        verifyAccount.setAccount(account);
        verifyAccount.setCreateDate(LocalDateTime.now());
        verifyAccount.setExpireDate(5);
        verifyAccount.setToken(token);
        verifyAccountRepository.save(verifyAccount);

        Map<String, Object> maps = new HashMap<>();
        maps.put("account", account);
        maps.put("token", token);

        Mail mail = new Mail();
        mail.setFrom("sobujsomahar@gmail.com");
        mail.setSubject("Registration");
        mail.setTo(account.getEmail());
        mail.setModel(maps);
        mailService.sendEmail(mail);

        return accountRepository.save(account);
    }

    @Override
    public Account updateAccount(AccountUpdateDto updateDto) throws Exception {
        Address address = new Address();
        address.setAddress(updateDto.getAddress());
        address.setCity(updateDto.getCity());
        address.setDistric(updateDto.getDistric());
        address.setZip(updateDto.getZip());
        return null;
    }

    @Override
    public void verifyCode(VerifyAccountDto codeVerifyDto) {
        String token = codeVerifyDto.getToken();
        VerifyAccount verifyAccount = verifyAccountRepository.findByToken(token).get();
        Account account = verifyAccount.getAccount();
        accountRepository.save(account);
    }

    @Override
    public Optional<Account> findByEmail(String email) {
        return accountRepository.findByEmail(email);
    }


    @Override
    public Optional<Account> findById(Long id) {
        return accountRepository.findById(id);
    }

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public Account findByName(String name){
        return accountRepository.findByName(name);
    }

    @Override
    public void delete(Long id) {
        Account account = accountRepository.findById(id).get();
        accountRepository.delete(account);
    }
}
