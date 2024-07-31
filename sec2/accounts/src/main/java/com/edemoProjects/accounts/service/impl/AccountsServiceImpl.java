package com.edemoProjects.accounts.service.impl;

import com.edemoProjects.accounts.constants.AccountsConstants;
import com.edemoProjects.accounts.dto.CustomerDto;
import com.edemoProjects.accounts.repository.AccountsRepository;
import com.edemoProjects.accounts.repository.CustomerRepository;
import com.edemoProjects.accounts.service.IAccountsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountsServiceImpl implements IAccountsService {

    private AccountsRepository accountRepository;
    private CustomerRepository customerRepository;

    @Override
    public void createAccount(CustomerDto customerDto) {


    }
}
