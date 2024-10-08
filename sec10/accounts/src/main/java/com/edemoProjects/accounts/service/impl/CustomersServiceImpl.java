package com.edemoProjects.accounts.service.impl;

import com.edemoProjects.accounts.dto.AccountsDto;
import com.edemoProjects.accounts.dto.CardsDto;
import com.edemoProjects.accounts.dto.CustomerDetailsDto;
import com.edemoProjects.accounts.dto.LoansDto;
import com.edemoProjects.accounts.entity.Accounts;
import com.edemoProjects.accounts.entity.Customer;
import com.edemoProjects.accounts.exception.ResourceNotFoundException;
import com.edemoProjects.accounts.mapper.AccountsMapper;
import com.edemoProjects.accounts.mapper.CustomerMapper;
import com.edemoProjects.accounts.repository.AccountsRepository;
import com.edemoProjects.accounts.repository.CustomerRepository;
import com.edemoProjects.accounts.service.ICustomersService;
import com.edemoProjects.accounts.service.client.CardsFeignClient;
import com.edemoProjects.accounts.service.client.LoansFeignClient;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomersServiceImpl implements ICustomersService {

    private AccountsRepository accountsRepository;
    private CustomerRepository customerRepository;
    private CardsFeignClient cardsFeignClient;
    private LoansFeignClient loansFeignClient;

    /**
     * @param mobileNumber - Input Mobile Number
     * @return Customer Details based on a given mobileNumber
     */
    @Override
    public CustomerDetailsDto fetchCustomerDetails(String mobileNumber, String correlationId) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber)
        );
        Accounts accounts = accountsRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(
                () -> new ResourceNotFoundException("Account", "customerId", customer.getCustomerId().toString())
        );

        CustomerDetailsDto customerDetailsDto = CustomerMapper.mapToCustomerDetailsDto(customer, new CustomerDetailsDto());
        customerDetailsDto.setAccountsDto(AccountsMapper.mapToAccountsDto(accounts, new AccountsDto()));

        ResponseEntity<LoansDto> loansDtoResponseEntity = loansFeignClient.fetchLoanDetails(correlationId, mobileNumber);
        customerDetailsDto.setLoansDto(loansDtoResponseEntity.getBody());

        ResponseEntity<CardsDto> cardsDtoResponseEntity = cardsFeignClient.fetchCardDetails(correlationId, mobileNumber);
        customerDetailsDto.setCardsDto(cardsDtoResponseEntity.getBody());

        return customerDetailsDto;

    }
}