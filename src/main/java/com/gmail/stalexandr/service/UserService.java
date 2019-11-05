package com.gmail.stalexandr.service;

import com.gmail.stalexandr.model.Account;
import com.gmail.stalexandr.model.User;
import com.gmail.stalexandr.model.UserInfo;
import com.gmail.stalexandr.repository.UserRepository;
import com.gmail.stalexandr.util.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.Date;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Transactional(readOnly = true)
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Transactional
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Transactional
    public boolean addUser(String email, String passHash, User user, UserInfo userInfo, Account account) {
        Date currDate = new Date();
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.YEAR, 1);
        Date validityDate = cal.getTime();

        if (userRepository.existsByEmail(email)) return false;

        account.setBalance(0.0);
        account.setUserInfo(userInfo);
        account.setValidity(validityDate);
        account.setUser(user);
        userInfo.setUser(user);
        user.setPassword(passHash);
        user.setRole(UserRole.CLIENT);
        userRepository.save(user);

        return true;
    }
}
