package com.gmail.stalexandr.repository;

import com.gmail.stalexandr.model.Credit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditRepository extends JpaRepository<Credit, Long> {
}
