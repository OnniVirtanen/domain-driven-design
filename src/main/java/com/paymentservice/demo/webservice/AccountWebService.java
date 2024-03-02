package com.paymentservice.demo.webservice;

import com.paymentservice.demo.api.AccountDTO;
import org.springframework.transaction.annotation.Transactional;

public interface AccountWebService {

    @Transactional(readOnly = true)
    AccountDTO getAccount(long accountId);

    @Transactional(readOnly = false)
    void createTestData(long amount);

}
