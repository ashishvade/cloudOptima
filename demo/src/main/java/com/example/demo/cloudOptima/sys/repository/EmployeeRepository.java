package com.example.demo.cloudOptima.sys.repository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.cloudOptima.sys.model.Employee;



public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	Employee findByEmployeeId(String employeeId);

	 List<Employee> findByLastAttendanceDate(LocalDateTime date );
	    
	    List<Employee> findByLastAttendanceDateBetween(Date startDate, Date endDate);
	 List<Employee> findByLastAttendanceDateBetween(LocalDateTime startDate, LocalDateTime endDate);
}
