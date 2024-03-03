package com.paymentservice.demo.webservice;

import com.paymentservice.demo.api.AccountDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

public interface AccountRestService {

    @Transactional(readOnly = true)
    AccountDTO getAccount(long accountId);

    @Transactional(readOnly = true)
    Page<AccountDTO> getAccounts(Pageable pageable);

    @Transactional(readOnly = false)
    void createTestData(long amount);

}
