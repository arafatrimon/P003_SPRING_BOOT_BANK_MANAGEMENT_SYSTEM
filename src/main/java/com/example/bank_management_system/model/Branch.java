package com.example.bank_management_system.model;

import lombok.Data;

@Data
public class Branch {
//(primary key)
    private long branch_id ;
private String branch_name;
private String address_line_1;
private String address_line_2;
private String city;
private String state;
private String country;
private String postal_code;
private String phone_number;
private String fax_number;
//(foreign key references EMPLOYEES.employee_id)
private String manager_id ;
private String date_opened;
}
