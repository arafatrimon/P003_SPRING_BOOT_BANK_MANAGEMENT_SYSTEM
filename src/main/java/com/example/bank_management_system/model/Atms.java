package com.example.bank_management_system.model;

public class Atms {
    //(primary key)
    private String atm_id;
    private String location;
    //(e.g. cash withdrawal, balance inquiry, funds transfer)
    private String services_available;
    private String maintenance_schedule;
    //(e.g. operational, out of service)
    private String status;
}
