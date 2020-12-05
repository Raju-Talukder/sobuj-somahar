package com.sobuj.service.account;

import com.sobuj.dto.AccountCreateDto;
import com.sobuj.dto.AccountUpdateDto;
import com.sobuj.dto.VerifyAccountDto;
import com.sobuj.mail.Mail;
import com.sobuj.mail.MailService;
import com.sobuj.models.Account;
import com.sobuj.models.Address;
import com.sobuj.models.Role;
import com.sobuj.models.VerifyAccount;
import com.sobuj.repository.AccountRepository;
import com.sobuj.repository.AddressRepository;
import com.sobuj.repository.VerifyAccountRepository;
import com.sobuj.service.address.AddressService;
import com.sobuj.service.product.ProductServiceImp;
import com.sobuj.service.role.RoleService;
import com.sobuj.utils.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

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
    private AddressRepository addressRepository;
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
        Address address = new Address();
        addressRepository.save(address);
        account.addAddress(address);
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
    public Account updateAccount(MultipartFile image, AccountUpdateDto updateDto) throws Exception {
        String fileName = StringUtils.cleanPath(image.getOriginalFilename());
        String uploadDir = "./photos/Profile";
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Account account = accountRepository.findByEmail(authentication.getName()).get();
        ProductServiceImp.photoDuplicate(image, fileName, uploadDir);
        Address address = addressRepository.findById(account.getId()).get();
        address.setAddress(updateDto.getAddress());
        address.setCity(updateDto.getCity());
        address.setDistric(updateDto.getDistric());
        address.setZip(updateDto.getZip());
        addressRepository.save(address);
        account.setPhoto(fileName);
        account.setName(updateDto.getName());
        account.setPhone(updateDto.getPhone());
        account.addAddress(address);
        return accountRepository.save(account);
    }

    @Override
    public void getProfileInfo(Model model, AccountService accountService, AddressService addressService) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Account account = accountService.findByEmail(authentication.getName())
                .orElseThrow(()->new IllegalArgumentException("Not found"));
        Address address = addressService.findById(account.getId())
                .orElseThrow(()->new IllegalArgumentException("Not found"));
        model.addAttribute("profile",account);
        model.addAttribute("address",address);
    }

    @Override
    public void showUserUpdateProfileFormData(Model model,AccountUpdateDto accountUpdateDto, AccountService accountService, AddressService addressService){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Account account = accountService.findByEmail(authentication.getName()).get();
        Address address = addressService.findById(account.getId()).get();
        accountUpdateDto.setId(account.getId());
        accountUpdateDto.setName(account.getName());
        accountUpdateDto.setPhoto(account.getPhoto());
        accountUpdateDto.setPhone(account.getPhone());
        accountUpdateDto.setCity(address.getCity());
        accountUpdateDto.setDistric(address.getDistric());
        accountUpdateDto.setAddress(address.getAddress());
        accountUpdateDto.setZip(address.getZip());
        model.addAttribute("accountUpdateDto",accountUpdateDto);
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
    public void verifyCode(VerifyAccountDto codeVerifyDto) {
        String token = codeVerifyDto.getToken();
        VerifyAccount verifyAccount = verifyAccountRepository.findByToken(token).get();
        Account account = verifyAccount.getAccount();
        accountRepository.save(account);
    }

    @Override
    public void delete(Long id) {
        Account account = accountRepository.findById(id).get();
        accountRepository.delete(account);
        Address address = addressRepository.findById(id).get();
        addressRepository.delete(address);
    }
}
