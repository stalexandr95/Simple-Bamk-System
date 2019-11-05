package com.gmail.stalexandr.repository;

import com.gmail.stalexandr.model.Deposit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepositRepository extends JpaRepository<Deposit, Long> {
}
