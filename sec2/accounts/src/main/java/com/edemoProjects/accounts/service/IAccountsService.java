package com.edemoProjects.accounts.service;

import com.edemoProjects.accounts.dto.CustomerDto;

public interface IAccountsService {

    // accepts parameter customerDto of CustomerDto object
    void createAccount(CustomerDto customerDto);

    CustomerDto fetchAccount(String mobileNumber);

    boolean updateAccount(CustomerDto customerDto);

    boolean deleteAccount(String mobileNumber);
}
