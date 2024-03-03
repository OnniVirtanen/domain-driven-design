package com.paymentservice.demo.webservice;

import com.paymentservice.demo.domain.Account;
import com.paymentservice.demo.service.AccountService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
@Service
public class AccountSoapServiceImpl {

    private final AccountService accountService;

    public AccountSoapServiceImpl(AccountService accountService) {
        this.accountService = accountService;
    }

    @ResponsePayload
    @PayloadRoot(namespace = "http://paymentservice.demo.com", localPart = "getAccountRequest")
    public GetAccountResponse getAccount(GetAccountRequest getAccountRequest) {
        return new GetAccountResponse(accountService.getAccount(getAccountRequest.getAccountId()));
    }

    @ResponsePayload
    @PayloadRoot(namespace = "http://paymentservice.demo.com", localPart = "saveAccountRequest")
    public Account saveAccount(Account account) {
        return accountService.saveAccount(account);
    }

    @ResponsePayload
    @PayloadRoot(namespace = "http://paymentservice.demo.com", localPart = "getAccountsRequest")
    public Page<Account> getAccounts(Pageable pageable) {
        return accountService.getAccounts(pageable);
    }

}
