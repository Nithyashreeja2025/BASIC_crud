package com.steffi.employeeandleave.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="employees")
public class Employee {
    @Id
    private String id;
    private int employeeId;
    private String employeeName;
    private int leaveBalance;

    public Employee() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public int getLeaveBalance() {
        return leaveBalance;
    }

    public void setLeaveBalance(int leaveBalance) {
        this.leaveBalance = leaveBalance;
    }
}
