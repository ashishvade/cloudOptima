package com.example.demo.cloudOptima.sys.model;

import java.time.LocalDateTime;
import java.util.Date;

public class EmployeeReport {

    private String employeeId;
    private LocalDateTime date;
    private LocalDateTime checkInTime;
    private LocalDateTime checkOutTime;
    private double totalHoursWorked;

    // Constructors, getters, setters, and other methods

    public EmployeeReport(String employeeId, LocalDateTime date, LocalDateTime checkInTime, LocalDateTime checkOutTime, double totalHoursWorked) {
        this.employeeId = employeeId;
        this.date = date;
        this.checkInTime = checkInTime;
        this.checkOutTime = checkOutTime;
        this.totalHoursWorked = totalHoursWorked;
    }

    public EmployeeReport() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
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