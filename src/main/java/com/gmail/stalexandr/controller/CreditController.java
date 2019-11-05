package com.gmail.stalexandr.controller;

import com.gmail.stalexandr.model.Credit;
import com.gmail.stalexandr.model.User;
import com.gmail.stalexandr.service.CreditService;
import com.gmail.stalexandr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("credit")
public class CreditController {

    @Autowired
    CreditService creditService;

    @Autowired
    UserService userService;

    private User dbUser;

    @GetMapping
    public String openCredit (Authentication authentication, Model model) {
        dbUser = userService.findByEmail(authentication.getName());
        Credit credit = dbUser.getAccount().getCredit();
        if (credit != null) {
            model.addAttribute("credit", credit);
            model.addAttribute("user", dbUser);
            return "credit";
        }
        else return "open_credit";
    }

    @PostMapping
    public String createCredit(@RequestParam String currUnit,
                               @RequestParam String limit,
                               @RequestParam String rate,
                               Credit credit, Model model) {
        creditService.addCredit(currUnit, limit, rate, dbUser.getAccount(), credit);
        userService.updateUser(dbUser);
        return "redirect/:credit";
    }
}
