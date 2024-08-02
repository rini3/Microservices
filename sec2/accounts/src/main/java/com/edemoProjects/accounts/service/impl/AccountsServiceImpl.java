package com.edemoProjects.accounts.service.impl;

import com.edemoProjects.accounts.constants.AccountsConstants;
import com.edemoProjects.accounts.dto.CustomerDto;
import com.edemoProjects.accounts.entity.Accounts;
import com.edemoProjects.accounts.entity.Customer;
import com.edemoProjects.accounts.exception.CustomerAlreadyExistException;
import com.edemoProjects.accounts.mapper.CustomerMapper;
import com.edemoProjects.accounts.repository.AccountsRepository;
import com.edemoProjects.accounts.repository.CustomerRepository;
import com.edemoProjects.accounts.service.IAccountsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class AccountsServiceImpl implements IAccountsService {

    private AccountsRepository accountRepository;
    private CustomerRepository customerRepository;

    @Override
    public void createAccount(CustomerDto customerDto) {

        Optional<Customer> check = customerRepository.findByMobileNumber(customerDto.getMobileNumber());
        if (check.isPresent()) {
            throw new CustomerAlreadyExistException("Customer already exists with given mobile number" + customerDto.getMobileNumber());
        }

        Customer customer = CustomerMapper.mapToCustomer(customerDto, new Customer());
        Customer savedCustomer = customerRepository.save(customer);
        accountRepository.save(createNewAccount(savedCustomer));
    }

    //@param customer - Customer Object
     //@return the new account details
    private Accounts createNewAccount(Customer customer) {

        Accounts newAccount = new Accounts();
        newAccount.setCustomerId(customer.getCustomerId());
        long randomAccNumber = 1000000000L + new Random().nextInt(900000000);

        newAccount.setAccountNumber(randomAccNumber);
        newAccount.setAccount_type(AccountsConstants.SAVINGS);
        newAccount.setBranch_address(AccountsConstants.ADDRESS);
        return newAccount;
    }

}
