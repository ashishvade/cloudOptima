package com.example.demo.cloudOptima.sys.model;

import java.time.LocalDateTime;
import java.util.Date;

import javax.annotation.processing.Generated;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee {

	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String employeeId;
    private String name;
    private String department;
    // Other employee details

    // Attendance fields
    private LocalDateTime lastAttendanceDate;
    private LocalDateTime checkInTime;
    private LocalDateTime checkOutTime;
	public Employee(Long id, String employeeId, String name, String department, LocalDateTime lastAttendanceDate,
			LocalDateTime checkInTime, LocalDateTime checkOutTime) {
		super();
		this.id = id;
		this.employeeId = employeeId;
		this.name = name;
		this.department = department;
		this.lastAttendanceDate = lastAttendanceDate;
		this.checkInTime = checkInTime;
		this.checkOutTime = checkOutTime;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public LocalDateTime getLastAttendanceDate() {
		return lastAttendanceDate;
	}
	public void setLastAttendanceDate(LocalDateTime lastAttendanceDate) {
		this.lastAttendanceDate = lastAttendanceDate;
	}
	public LocalDateTime getCheckInTime() {
		return checkInTime;
	}
	public void setCheckInTime(LocalDateTime localDateTime) {
		this.checkInTime = localDateTime;
	}
	public LocalDateTime getCheckOutTime() {
		return checkOutTime;
	}
	public void setCheckOutTime(LocalDateTime checkOutTime) {
		this.checkOutTime = checkOutTime;
	}
}
