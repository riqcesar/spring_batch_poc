package com.picpay.banking.file.generator.batch;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankslipRepository extends JpaRepository<Bankslip, Long> {

   Page<Bankslip> findByStatus(Status status, Pageable pageable);



}
