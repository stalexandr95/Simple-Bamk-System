package com.gmail.stalexandr.controller;

import com.gmail.stalexandr.model.Credit;
import com.gmail.stalexandr.model.Deposit;
import com.gmail.stalexandr.model.User;
import com.gmail.stalexandr.service.CreditService;
import com.gmail.stalexandr.service.DepositService;
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
public class DepositController {

    @Autowired
    DepositService depositService;

    @Autowired
    UserService userService;

    private User dbUser;

    @GetMapping
    public String openDeposit (Authentication authentication, Model model) {
        dbUser = userService.findByEmail(authentication.getName());
        Deposit deposit = dbUser.getAccount().getDeposit();
        if (deposit != null) {
            model.addAttribute("credit", deposit);
            model.addAttribute("user", dbUser);
            return "deposit";
        }
        else return "open_deposit";
    }

    @PostMapping
    public String createDeposit(@RequestParam String currUnit,
                               @RequestParam String rate,
                               Deposit deposit, Model model) {
       depositService.addDeposit(currUnit, rate, dbUser.getAccount(), deposit);
        userService.updateUser(dbUser);
        return "redirect/:deposit";
    }
}
