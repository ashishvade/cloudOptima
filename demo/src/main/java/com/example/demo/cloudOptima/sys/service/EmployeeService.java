package com.example.demo.cloudOptima.sys.service;



import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.cloudOptima.sys.model.Employee;
import com.example.demo.cloudOptima.sys.model.EmployeeReport;
import com.example.demo.cloudOptima.sys.repository.EmployeeRepository;



@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee saveEmployeeDetails(Employee employee) {
        if (employee.getEmployeeId() == null || employee.getEmployeeId().isEmpty()) {
            throw new IllegalArgumentException("Employee ID cannot be null or empty");
        }
        return employeeRepository.save(employee);
    }
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
    public Employee getEmployeeByEmployeeId(String employeeId) {
        return employeeRepository.findByEmployeeId(employeeId);
    }

    public Employee checkOutEmployee(String employeeId) {
        Employee employee = employeeRepository.findByEmployeeId(employeeId);

        if (employee != null && employee.getCheckOutTime() == null) {
            employee.setCheckOutTime(null);
            return employeeRepository.save(employee);
        }

        return null;
    }

    public Employee updateEmployeeDetails(String employeeId, Employee updatedEmployee) {
        Employee existingEmployee = employeeRepository.findByEmployeeId(employeeId);

        if (existingEmployee != null) {
            existingEmployee.setName(updatedEmployee.getName());
            existingEmployee.setDepartment(updatedEmployee.getDepartment());

            return employeeRepository.save(existingEmployee);
        }

        return null;
    }

    public void deleteEmployeeByEmployeeId(String employeeId) {
        Employee existingEmployee = employeeRepository.findByEmployeeId(employeeId);

        if (existingEmployee != null) {
            employeeRepository.delete(existingEmployee);
        }
    }

    public void recordCheckIn(String employeeId) {
        validateEmployeeId(employeeId);

        Employee employee = employeeRepository.findByEmployeeId(employeeId);
        if (employee != null) {
            employee.setCheckInTime(LocalDateTime.now());
            employeeRepository.save(employee);
        }
    }

    public void recordCheckOut(String employeeId) {
        validateEmployeeId(employeeId);

        Employee employee = employeeRepository.findByEmployeeId(employeeId);
        if (employee != null) {
            employee.setCheckOutTime(LocalDateTime.now());
            employeeRepository.save(employee);
        }
    }

    private void validateEmployeeId(String employeeId) {
        if (employeeId == null || employeeId.isEmpty()) {
            throw new IllegalArgumentException("Employee ID cannot be null or empty");
        }
    }

    public List<EmployeeReport> getAttendanceReportDaily(LocalDate date) {
    	LocalDateTime startOfDay = date.atStartOfDay();
        LocalDateTime endOfDay = date.atTime(23, 59, 59);

        List<Employee> attendanceRecords = employeeRepository.findByLastAttendanceDateBetween(startOfDay, endOfDay);

        List<EmployeeReport> attendanceReports = generateEmployeeReports(attendanceRecords);

        for (EmployeeReport report : attendanceReports) {
            LocalDateTime checkInTime = report.getCheckInTime();
            LocalDateTime checkOutTime = report.getCheckOutTime();
            report.setTotalHoursWorked(calculateTotalHoursWorked(checkInTime, checkOutTime));
        }

        return attendanceReports;
    }

    public List<EmployeeReport> getAttendanceReportWeekly(LocalDate startDate, LocalDate endDate) {
        LocalDateTime startOfDay = startDate.atStartOfDay();
        LocalDateTime endOfDay = endDate.atTime(23, 59, 59);

        List<Employee> attendanceRecords = employeeRepository.findByLastAttendanceDateBetween(startOfDay, endOfDay);

        return generateEmployeeReports(attendanceRecords);
    }

    public List<EmployeeReport> getAttendanceReportMonthly(YearMonth month) {
        LocalDateTime startOfMonth = month.atDay(1).atStartOfDay();
        LocalDateTime endOfMonth = month.atEndOfMonth().atTime(23, 59, 59);

        List<Employee> attendanceRecords = employeeRepository.findByLastAttendanceDateBetween(startOfMonth, endOfMonth);

        return generateEmployeeReports(attendanceRecords);
    }

    public double calculateTotalHoursWorked(LocalDateTime checkInTime, LocalDateTime checkOutTime) {
        if (checkInTime == null || checkOutTime == null) {
            return 0; 
        }

        Duration duration = Duration.between(checkInTime, checkOutTime);
        return duration.toHours();
    }

    private List<EmployeeReport> generateEmployeeReports(List<Employee> attendanceRecords) {
        List<EmployeeReport> reports = new ArrayList<>();
        for (Employee employee : attendanceRecords) {
            EmployeeReport report = new EmployeeReport(
                employee.getEmployeeId(),
                employee.getName(),         
                employee.getDepartment(),  
                employee.getLastAttendanceDate(),
                employee.getCheckInTime(),
                employee.getCheckOutTime(),
                calculateTotalHoursWorked(employee.getCheckInTime(), employee.getCheckOutTime())
            );
            reports.add(report);
        }
        return reports;
    }

}



