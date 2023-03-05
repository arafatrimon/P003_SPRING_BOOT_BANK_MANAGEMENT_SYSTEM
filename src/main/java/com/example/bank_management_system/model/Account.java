package com.example.bank_management_system.model;

import lombok.Data;

@Data
public class Account {
    //(primary key)
    private long account_id;
    //(foreign key references CUSTOMERS.customer_id)
    private String customer_id;
    //(e.g. checking, savings, money market, CD)
    private String account_type;
    private String account_number;
    // (e.g. active, closed)
    private String account_status;
    private String balance;
    private String available_balance;
    private String interest_rate;
    private String date_opened;
    private String last_transaction_date;
    private String overdraft_protection_enabled;
    private String overdraft_limit;

}
