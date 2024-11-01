package com.micro.loans.service.impl;

import com.micro.loans.constant.LoansConstants;
import com.micro.loans.dto.LoansDto;
import com.micro.loans.entity.Loans;
import com.micro.loans.exception.LoanAlreadyExistsException;
import com.micro.loans.exception.ResourceNotFoundException;
import com.micro.loans.mapper.LoansMapper;
import com.micro.loans.repository.LoansRepository;
import com.micro.loans.service.ILoansService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Random;

@Component
@AllArgsConstructor
public class LoansService implements ILoansService {

    LoansRepository loansRepository;

    @Override
    public void createLoan(String mobileNumber) {
       Optional<Loans> loans =  loansRepository.findByMobileNumber(mobileNumber);
       if(loans.isPresent()) {
           throw new LoanAlreadyExistsException("Loan already exists");
       }
       loansRepository.save(createLoans(mobileNumber));
    }

    @Override
    public LoansDto fetchLoan(String mobileNumber) {
       Loans loans = loansRepository.findByMobileNumber(mobileNumber).orElseThrow(() -> new ResourceNotFoundException("Loans", "mobileNumber", mobileNumber));
       return LoansMapper.mapToLoansDto(loans, new LoansDto());
    }

    @Override
    public boolean updateLoans(LoansDto loansDto) {
        Loans loans = loansRepository.findByLoanNumber(loansDto.getLoanNumber()).orElseThrow(() -> new ResourceNotFoundException("Loans", "loanNumber", loansDto.getLoanNumber()));
        LoansMapper.maptoLoans(loansDto, loans);
        loansRepository.save(loans);
        return true;
    }

    @Override
    public boolean deleteLoans(String mobileNumber) {
        Loans loans = loansRepository.findByMobileNumber(mobileNumber).orElseThrow(() -> new ResourceNotFoundException("Loans", "mobileNumber", mobileNumber));
        loansRepository.deleteById(loans.getLoanId());
        return true;
    }

    private Loans createLoans(String mobileNumber) {
        Loans loans = new Loans();
        long loanNumber = 100000000000L + new Random().nextInt(100000000);
        loans.setLoanNumber(Long.toString(loanNumber));
        loans.setMobileNumber(mobileNumber);
        loans.setLoanType(LoansConstants.HOME_LOAN);
        loans.setTotalLoan(LoansConstants.NEW_LOAN_LIMIT);
        loans.setAmountPaid(0);
        loans.setOutstandingAmount(LoansConstants.NEW_LOAN_LIMIT);
        return loans;
    }
}
