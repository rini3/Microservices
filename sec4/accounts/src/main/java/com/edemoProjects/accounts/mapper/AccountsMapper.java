package com.edemoProjects.accounts.mapper;

import com.edemoProjects.accounts.dto.AccountsDto;
import com.edemoProjects.accounts.entity.Accounts;

public class AccountsMapper {

    public static AccountsDto mapToAccountsDto(Accounts accounts, AccountsDto accountsDto) {
        accountsDto.setAccountNumber(accounts.getAccountNumber());
        accountsDto.setAccount_type(accounts.getAccount_type());
        accountsDto.setBranch_address(accounts.getBranch_address());
        return accountsDto;
    }

    public static Accounts mapToAccounts(AccountsDto accountsDto, Accounts accounts) {
        accounts.setAccountNumber(accountsDto.getAccountNumber());
        accounts.setAccount_type(accountsDto.getAccount_type());
        accounts.setBranch_address(accountsDto.getBranch_address());
        return accounts;
    }

}