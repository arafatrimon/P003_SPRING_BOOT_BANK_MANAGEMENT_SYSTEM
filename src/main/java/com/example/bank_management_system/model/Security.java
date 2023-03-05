package com.example.bank_management_system.model;

import lombok.Data;

@Data
public class Security {

    private long security_id;
private String authentication_protocol;
private String firewall_type;
private String intrusion_detection_system;
private String antivirus_software;
private String security_audit_schedule;
private String disaster_recovery_plan;
private String data_backup_schedule;
private String data_encryption_enabled;

}
