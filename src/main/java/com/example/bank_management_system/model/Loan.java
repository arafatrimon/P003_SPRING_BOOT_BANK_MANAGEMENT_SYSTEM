package com.example.bank_management_system.model;

public class Loan {
    // (primary key)
    private String loan_id;
    //(foreign key references CUSTOMERS.customer_id)
    private String customer_id;
    //(e.g. personal loan, auto loan, mortgage)
    private String loan_type;
    private String loan_amount;
    private String interest_rate;
    private String origination_date;
    private String first_payment_date;
    private String term_in_months;
    private String payment_amount;
    private String date_approved;
    private String date_disbursed;
    private String outstanding_balance;
    //(if any)
    private String collateral_type;
    //(if any)
    private String collateral_value;
}
