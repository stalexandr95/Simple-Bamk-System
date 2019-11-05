package com.gmail.stalexandr.service;

import com.gmail.stalexandr.model.Account;
import com.gmail.stalexandr.model.Credit;
import com.gmail.stalexandr.repository.CreditRepository;
import com.gmail.stalexandr.util.CurrUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CreditService {
    @Autowired
    CreditRepository creditRepository;

    @Transactional
    public void addCredit(String currency, String limit, String rate, Account account, Credit credit){

        credit.setBalance(0.0);
        credit.setCurrUnit(CurrUnit.valueOf(currency));
        credit.setLimit(Double.valueOf(limit));
        credit.setRate(Double.valueOf(rate));
        credit.setAccruedInterest(0.0);
        credit.setAccount(account);
        account.setCredit(credit);

        creditRepository.save(credit);
    }
}
