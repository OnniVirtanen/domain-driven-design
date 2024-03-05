package com.paymentservice.demo.domain.repository;

import com.paymentservice.demo.domain.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AccountRepository extends BaseRepository<Account, Long> {

    Page<Account> findAll(Pageable pageable);

}
