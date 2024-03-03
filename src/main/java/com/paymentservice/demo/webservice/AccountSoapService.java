package com.paymentservice.demo.webservice;

import com.paymentservice.demo.domain.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AccountSoapService {

    Account getAccount(long accountId);

    Account saveAccount(Account account);

    Page<Account> getAccounts(Pageable pageable);

}
