package com.gmail.stalexandr.controller;

import com.gmail.stalexandr.model.Account;
import com.gmail.stalexandr.model.User;
import com.gmail.stalexandr.model.UserInfo;
import com.gmail.stalexandr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("registration")
public class RegistrationController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping
    public String registration() {
        return "registration";
    }

    @PostMapping
    public String addUser(@RequestParam String email,
                   @RequestParam String password,
                   User user, UserInfo userInfo, Account account, Model model) {

        String passHash = passwordEncoder.encode(password);
        if ("".equals(email) ||
                !userService.addUser(email, passHash, user, userInfo, account)) {
            model.addAttribute("exists", true);
            model.addAttribute("email", email);
            return "registration";
        }
        return "redirect:/login";

    }

    //TODO Try to add salt

}
