// use mysql in database

// start application on port 8092
//username =root
password=1234

database =emp
table =employee



test Api in Postman
//to insert employee detailes
	//post
	//http://localhost:8092/api/employees/insert
	
	
	
	// to view detailes of employee
	//get
	//http://localhost:8092/api/employees/view/em02
	
	
	
	//to checkout employee
	//post
	//http://localhost:8092/api/employees/checkout/em01
	
	
	//to update employeeDetailes
	 //put
	 //http://localhost:8092/api/employees/update/em01
	  //to delete employeeDetailes
	 //delete
	 //http://localhost:8092/api/employees/delete/em03
	 
	 
	 
	 //to checkin insert 
	 //post
	 //http://localhost:8092/api/employees/em02/check-in
	 
	 
	  //to checkout insert 
	 //post
	 //http://localhost:8092/api/employees/em03/check-out
	 
	  //to get daily aatandence report
	 //get
	 //http://localhost:8092/api/employees/attendance-report/daily?date=2024-01-21
	 
	 //to get weekly aatandence report
		 //get
	 //http://localhost:8092/api/employees/attendance-report/weekly?startDate=2024-01-21&endDate=2024-01-28
	  //to get monthly report
	   //get
	   //http://localhost:8092/api/employees/attendance-report/monthly?month=2024-01