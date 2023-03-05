package com.example.bank_management_system.model;

import lombok.Data;

@Data
public class Customer {
    //(primary key)
    private long customer_id;
    private String first_name;
    private String middle_name;
    private String last_name;
    private String date_of_birth;
    private String gender;
    private String email;
    private String phone_number;
    private String alternate_phone_number;
    private String address_line_1;
    private String address_line_2;
    private String city;
    private String state;
    private String country;
    private String postal_code;
    // (e.g. passport, driver's license)
    private String identification_type;
    private String identification_number;
    private String identification_issue_date;
    private String identification_expiry_date;
    private String marital_status;
    private String spouse_first_name;
    private String spouse_last_name;
    private String employment_status;
    private String employer_name;
    private String employer_address;
    private String employer_phone_number;
    private String occupation;
    private String annual_income;
    private String credit_score;
}
