package com.example.demo.cloudOptima.sys.model;

import java.time.LocalDateTime;

public class EmployeeReport {

    private String employeeId;
    private String name;
    private String department;
    private LocalDateTime date;
    private LocalDateTime checkInTime;
    private LocalDateTime checkOutTime;
    private double totalHoursWorked;

    public EmployeeReport(String employeeId, String name, String department, LocalDateTime date,
                          LocalDateTime checkInTime, LocalDateTime checkOutTime, double totalHoursWorked) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.date = date;
        this.checkInTime = checkInTime;
        this.checkOutTime = checkOutTime;
        this.totalHoursWorked = totalHoursWorked;
    }


    public EmployeeReport() {
		super();
		
	}


	public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public LocalDateTime getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(LocalDateTime checkInTime) {
        this.checkInTime = checkInTime;
    }

    public LocalDateTime getCheckOutTime() {
        return checkOutTime;
    }

    public void setCheckOutTime(LocalDateTime checkOutTime) {
        this.checkOutTime = checkOutTime;
    }

    public double getTotalHoursWorked() {
        return totalHoursWorked;
    }

    public void setTotalHoursWorked(double totalHoursWorked) {
        this.totalHoursWorked = totalHoursWorked;
    }
}
