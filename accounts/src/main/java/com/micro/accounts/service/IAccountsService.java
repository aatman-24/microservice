package com.micro.accounts.service;

import com.micro.accounts.dto.CustomerDto;

public interface IAccountsService {



    /**
     * This method creates a new account in the database.
     *
     * @param customerDto The customer details for which the account needs to be created.
     */
    void createAccount(CustomerDto customerDto);

    /**
     * Fetches the account details for the given mobile number from the database.
     *
     * @param mobileNumber The mobile number for which the account details are to be fetched.
     * @return A CustomerDto object containing the account details.
     */
    CustomerDto fetchAccount(String mobileNumber);


    Boolean updateAccount(CustomerDto customerDto);

    Boolean deleteAccount(String mobileNumber);
}
