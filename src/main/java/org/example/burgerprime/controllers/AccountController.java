package org.example.burgerprime.controllers;

import lombok.AllArgsConstructor;
import org.example.burgerprime.models.Account;
import org.example.burgerprime.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@Controller
public class AccountController {
    private final UserService userService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/registration")
    public String registration() {
        return "reg";
    }


    @PostMapping("/registration")
    public String createUser(Account user, Model model) {
        if(!userService.createUser(user)){
            model.addAttribute("error message", "Пользователь с таким именем уже существует");
            return "reg";
        }
        userService.createUser(user);
        return "redirect:/login";
    }

    @GetMapping("/hello")
    public String securityUrl() {
        return "hello";
    }
}
