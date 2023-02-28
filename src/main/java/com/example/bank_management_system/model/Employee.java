package com.example.bank_management_system.model;

public class Employee {
    //(primary key)
    private String employee_id;
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
    private String job_title;
    private String department;
    private String date_hired;
    private String date_terminated;
    private String termination_reason;
    //(foreign key references EMPLOYEES.employee_id)
    private String manager_id;
    private String salary;
    private String bonus;
    private String stock_options;
}
