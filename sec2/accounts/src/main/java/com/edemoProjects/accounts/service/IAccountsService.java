package com.edemoProjects.accounts.service;

import com.edemoProjects.accounts.dto.CustomerDto;

public interface IAccountsService {

    // accepts parameter customerDto of CustomerDto object
    void createAccount(CustomerDto customerDto);

}
