package com.micro.loans.service;

import com.micro.loans.constant.LoansConstants;
import com.micro.loans.dto.LoansDto;
import com.micro.loans.entity.Loans;

public interface ILoansService {
    void createLoan(String mobileNumber);

    LoansDto fetchLoan(String mobileNumber);

    boolean updateLoans(LoansDto loansDto);

    boolean deleteLoans(String mobileNumber);
}
