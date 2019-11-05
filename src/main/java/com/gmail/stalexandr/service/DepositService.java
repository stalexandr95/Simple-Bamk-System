package com.gmail.stalexandr.service;

import com.gmail.stalexandr.model.Account;
import com.gmail.stalexandr.model.Deposit;
import com.gmail.stalexandr.repository.DepositRepository;
import com.gmail.stalexandr.util.CurrUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.Date;

@Service
public class DepositService {

    @Autowired
    DepositRepository depositRepository;

    @Transactional
    public void addDeposit(String currUnit, String rate,
                           Account account, Deposit deposit) {
        Date currDate = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(currDate);
        cal.add(Calendar.YEAR, 1);
        Date term = cal.getTime();

        deposit.setBalance(0.0);
        deposit.setCurrUnit(CurrUnit.valueOf(currUnit));
        deposit.setRate(Double.valueOf(rate));
        deposit.setTerm(term);
        deposit.setAccount(account);
        account.setDeposit(deposit);
        depositRepository.save(deposit);

    }
}
