package org.example.burgerprime.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.burgerprime.interfaces.AccountInformationRepository;
import org.example.burgerprime.interfaces.AccountRepository;
import org.example.burgerprime.interfaces.BasketRepository;
import org.example.burgerprime.models.*;
import org.example.burgerprime.services.Service;
import org.example.burgerprime.services.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@AllArgsConstructor
@Controller
@Slf4j
public class AccountController {
    private final UserService userService;
    private final AccountRepository accountRepository;
    private final AccountInformationRepository accountInformationRepository;
    @GetMapping("/profile/datas")
    public String profileData() {
        return "datas";
    }
    @PostMapping("/account/add_data")
    public String addData(Authentication authentication, String displayed_name, String phone_number, String gender, String email, String date_of_birth) {
        Object principal = authentication.getPrincipal();
        String username = ((UserDetails) principal).getUsername();
        Account account = accountRepository.findByName(username);
        AccountInformation accountInformation = accountInformationRepository.findByAccount(account);
        accountInformation.setDisplayed_name(displayed_name);
        accountInformation.setPhone_number(phone_number);
        accountInformation.setGender(gender);
        accountInformation.setEmail(email);
        accountInformation.setDate_of_birth(date_of_birth);
        accountInformationRepository.save(accountInformation);
        return "redirect:/profile";
    }
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }


    @PostMapping("/registration")
    public String createUser(Account user, Model model) {
        if(!userService.createUser(user)){
            model.addAttribute("errorMessage", "Пользователь уже существует");
            return "registration";
        }
        userService.createUser(user);
        return "redirect:/login";
    }
    @GetMapping("/profile")
    public String profile( Model model, Authentication authentication) {
        Object principal = authentication.getPrincipal();

        if (principal instanceof UserDetails) {
            String username = ((UserDetails) principal).getUsername();
            Account account = accountRepository.findByName(username);
            AccountInformation accountInformation = accountInformationRepository.findByAccount(account);
            model.addAttribute("accountInformation", accountInformation);
            return "profile";
        }
        return "profile";
    }
    @PostMapping("/profile/edit_name")
    public String editName(Authentication authentication, String new_name) {
        Object principal = authentication.getPrincipal();
        String username = ((UserDetails) principal).getUsername();
        Account account = accountRepository.findByName(username);
        account.setName(new_name);
        accountRepository.save(account);
        log.info("User {} changed name to {}", username, new_name);
        return "redirect:/login";
    }
    @PostMapping("/profile/add_address")
    public String addAddress(Authentication authentication, String address) {
        Object principal = authentication.getPrincipal();
        String username = ((UserDetails) principal).getUsername();
        Account account = accountRepository.findByName(username);
        AccountInformation accountInformation = accountInformationRepository.findByAccount(account);
        accountInformation.setAddress(address);
        accountInformationRepository.save(accountInformation);
        return "redirect:/basket";
    }

//    @PostMapping("/profile/edit_avatar")
//    public String editAvatar(Authentication authentication, @RequestParam("file") MultipartFile file) throws IOException {
//        Image avatar;
//        Object principal = authentication.getPrincipal();
//        String username = ((UserDetails) principal).getUsername();
//        Account account = accountRepository.findByName(username);
//        if (file.getSize() != 0) {
//            avatar = service.toImageEntity(file);
//            account.setAvatar(avatar);
//        }
//        Account accountFromDb = accountRepository.save(account);
//        accountFromDb.setAvatarId(accountFromDb.getAvatar().getId());
//        accountRepository.save(account);
//        return "redirect:/login";
//    }
}
