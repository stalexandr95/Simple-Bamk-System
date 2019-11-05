package com.gmail.stalexandr.controller;

import com.gmail.stalexandr.model.User;
import com.gmail.stalexandr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class UserController {

    @Autowired
    UserService userService;

    //    @GetMapping("/")
//    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
//        model.addAttribute("name", name);
//        return "index";
//    }


//    @PostMapping(path = "/add")
//    public @ResponseBody
//    String addNewUser(@RequestParam String email, @RequestParam String password) {
//        // @ResponseBody means the returned String is the response, not a view name
//        // @RequestParam means it is a parameter from the GET or POST request
//
//        User u = new User();
//        u.setEmail(email);
//        u.setPassword(password);
//        userRepository.save(u);
//        return "Saved";
//    }

    @GetMapping("/client")
    public String getClient(Model model, Authentication authentication) {
        User dbUser = userService.findByEmail(authentication.getName());
        model.addAttribute("client", dbUser);
        return "client";
    }
}
