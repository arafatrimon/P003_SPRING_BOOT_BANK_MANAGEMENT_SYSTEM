package com.example.bank_management_system.model;

import lombok.Data;

@Data
public class Transaction {
//(primary key)
    private long transaction_id ;
    // (foreign key references ACCOUNTS.account_id)
private String account_id;
//(e.g. deposit, withdrawal, transfer)
private String transaction_type ;
private String transaction_date;
private String amount;
private String description;
private String check_number;
//(e.g. food, transportation, entertainment)
private String transaction_category ;
//(e.g. groceries, dining out, movies)
private String transaction_subcategory ;
private String merchant_name;
private String merchant_city;
private String merchant_state;
private String merchant_country;
}
