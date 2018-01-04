package com.healthabove60.service;

import java.util.List;

import com.healthabove60.dto.EmployeeDTO;
import com.healthabove60.dto.ResponseDTO;
import com.healthabove60.jpa.entity.Employee;

public interface EmployeeService {

	public ResponseDTO addEmployee(EmployeeDTO employeeDTO);

	public List<Employee> getAllEmployees();
	
	public Employee getActiveEmployees();

	public Employee getEmployee(String empId);

}