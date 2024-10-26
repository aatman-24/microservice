package com.micro.accounts.mapper;

import com.micro.accounts.dto.AccountsDto;
import com.micro.accounts.entity.Accounts;

public class AccountsMapper {

    /**
     * Maps the given Accounts object to an AccountsDto object.
     *
     * @param accounts     The Accounts object to be mapped.
     * @param accountsDto  The AccountsDto object to which the given Accounts
     *                     object is to be mapped.
     * @return The mapped AccountsDto object.
     */
    public static AccountsDto mapToAccountDto(Accounts accounts, AccountsDto accountsDto) {
        accountsDto.setAccountNumber(accounts.getAccountNumber());
        accountsDto.setAccountType(accounts.getAccountType());
        accountsDto.setBranchAddress(accounts.getBranchAddress());
        return accountsDto;
    }

    /**
     * Maps the given AccountsDto object to the given Accounts object.
     *
     * @param accountsDto The AccountsDto object to be mapped.
     * @param accounts    The Accounts object to which the given AccountsDto
     *                    object is to be mapped.
     * @return The mapped Accounts object.
     */
    public static Accounts mapToAccounts(AccountsDto accountsDto, Accounts accounts) {
        accounts.setAccountNumber(accountsDto.getAccountNumber());
        accounts.setAccountType(accountsDto.getAccountType());
        accounts.setBranchAddress(accountsDto.getBranchAddress());
        return accounts;
    }
}
