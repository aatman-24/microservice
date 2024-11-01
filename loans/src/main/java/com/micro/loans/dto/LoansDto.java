package com.micro.loans.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

@Data
public class LoansDto {

    @NotEmpty(message = "Mobile Number is required")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile Number must be 10 digit")
    private String mobileNumber;

    @NotEmpty(message = "Loan Number is required")
    @Pattern(regexp = "(^$|[0-9]{12})", message = "Loan Number must be 12 digit")
    private String loanNumber;

    @NotEmpty(message = "Loan Type is required")
    private String loanType;

    @Positive(message = "Total Loan must be positive")
    private int totalLoan;

    @PositiveOrZero(message = "Amount paid must be positive or zero")
    private int amountPaid;

    @PositiveOrZero(message = "Outstanding amount must be positive or zero")
    private int outstandingAmount;
}
