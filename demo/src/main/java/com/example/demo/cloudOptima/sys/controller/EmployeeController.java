package com.example.demo.cloudOptima.sys.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.cloudOptima.sys.model.Employee;
import com.example.demo.cloudOptima.sys.model.EmployeeReport;
import com.example.demo.cloudOptima.sys.service.EmployeeService;



@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	
	private final EmployeeService employeeService;
	
	@Autowired
	public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
	
	
	//to insert employee detailes
	//post
	//http://localhost:8092/api/employees/insert
	@PostMapping("/insert")
    public Employee insertEmployee(@RequestBody Employee employee) {
		// Set lastAttendanceDate to current date
        employee.setLastAttendanceDate(LocalDateTime.now());

        // Set checkInTime to current date (initially)
        employee.setCheckInTime(LocalDateTime.now());

        // Set checkOutTime to null initially
        employee.setCheckOutTime(null);
        employee.setTotalHoursWorked(0);
        return employeeService.saveEmployeeDetails(employee);
    }
	
	
	
	// to view detailes of employee
	//get
	//http://localhost:8092/api/employees/view/em02
	@GetMapping("/view/{employeeId}")
    public Employee viewEmployee(@PathVariable String employeeId) {
        return employeeService.getEmployeeByEmployeeId(employeeId);
    }
	
	//to checkout employee
	//post
	//http://localhost:8092/api/employees/checkout/em01
	 @PostMapping("/checkout/{employeeId}")
	    public Employee checkOutEmployee(@PathVariable String employeeId) {
	        return employeeService.checkOutEmployee(employeeId);
	    }
	
	//to update employeeDetailes
	 //put
	 //http://localhost:8092/api/employees/update/em01
	 @PutMapping("/update/{employeeId}")
	    public Employee updateEmployee(@PathVariable String employeeId, @RequestBody Employee updatedEmployee) {
	        return employeeService.updateEmployeeDetails(employeeId, updatedEmployee);
	    }
	 
	 
	 //to delete employeeDetailes
	 //delete
	 //http://localhost:8092/api/employees/delete/em03
	 @DeleteMapping("/delete/{employeeId}")
	    public void deleteEmployee(@PathVariable String employeeId) {
	        employeeService.deleteEmployeeByEmployeeId(employeeId);
	    }
	 
	
	 
	 
	 @PostMapping("/details")
	    public Employee saveEmployeeDetails(@RequestBody Employee employee) {
	        try {
	            return employeeService.saveEmployeeDetails(employee);
	        } catch (IllegalArgumentException e) {
	            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
	        }
	    }
	 
	 
	 //to checkin insert 
	 //post
	 //http://localhost:8092/api/employees/em02/check-in
	 @PostMapping("/{employeeId}/check-in")
	    public void recordCheckIn(@PathVariable String employeeId) {
	        try {
	            employeeService.recordCheckIn(employeeId);
	        } catch (ResponseStatusException e) {
	            throw e;
	        } catch (Exception e) {
	            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error", e);
	        }
	    }
	 
	 //to checkout insert 
	 //post
	 //http://localhost:8092/api/employees/em03/check-out
	 @PostMapping("/{employeeId}/check-out")
	    public void recordCheckOut(@PathVariable String employeeId) {
	        try {
	            employeeService.recordCheckOut(employeeId);
	        } catch (ResponseStatusException e) {
	            throw e;
	        } catch (Exception e) {
	            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error", e);
	        }
	    }
	 
	 //to get daily aatandence report
	 //get
	 //http://localhost:8092/api/employees/attendance-report/daily?date=2024-01-21
	 @GetMapping("/attendance-report/daily")
	    public List<EmployeeReport> getAttendanceReportDaily(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
	        
		    System.out.println("Received date parameter: " + date);
		    List<EmployeeReport> attendanceReport = employeeService.getAttendanceReportDaily(date);
		    System.out.println("Result of the query: " + attendanceReport);
		 return attendanceReport;
	    }
	 
	//to get weekly aatandence report
		 //get
	 //http://localhost:8092/api/employees/attendance-report/weekly?startDate=2024-01-21&endDate=2024-01-28
	   @GetMapping("/attendance-report/weekly")
	    public List<EmployeeReport> getAttendanceReportWeekly(
	            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
	            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate) {
	        return employeeService.getAttendanceReportWeekly(startDate, endDate);
	    }

	   
	   //to get monthly report
	   //get
	   //http://localhost:8092/api/employees/attendance-report/monthly?month=2024-01
	   @GetMapping("/attendance-report/monthly")
	   public List<EmployeeReport> getAttendanceReportMonthly(
	           @RequestParam @DateTimeFormat(pattern = "yyyy-MM") YearMonth month) {
	       return employeeService.getAttendanceReportMonthly(month);
	   }
}