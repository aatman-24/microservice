package com.micro.loans.constant;

public class LoansConstants {

    private LoansConstants() {}

    // Status
    public static final String STATUS_200 = "200";
    public static final String STATUS_201 = "201";
    public static final String STATUS_500 = "500";
    public static final String STATUS_417 = "417";

    // Message
    public static final String MESSAGE_200 = "Request processed successfully";
    public static final String MESSAGE_201 = "Loan Created successfully";
    public static final String MESSAGE_500 = "An error occurred, please try again later";
    public static final String MESSAGE_417_UPDATE = "Update operation failed, please try again later";
    public static final String MESSAGE_417_DELETE = "Delete operation failed, please try again later";

    // Loan Type
    public static final String HOME_LOAN = "Home Loan";
    public static final String CAR_LOAN = "Car Loan";

    // Limit
    public static final int NEW_LOAN_LIMIT = 50000;
}
