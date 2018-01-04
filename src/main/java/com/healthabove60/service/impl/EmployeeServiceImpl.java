package com.healthabove60.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.healthabove60.dto.EmployeeDTO;
import com.healthabove60.dto.ResponseDTO;
import com.healthabove60.jpa.converter.EmployeeConverter;
import com.healthabove60.jpa.entity.Employee;
import com.healthabove60.jpa.repository.EmployeeJpaRepository;
import com.healthabove60.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeJpaRepository employeeJpaRepository;
	
	@Autowired
	private EmployeeConverter employeeConverter;
	
	@Override
	public List<Employee> getAllEmployees() {
		return employeeJpaRepository.findAll();
	}

	@Override
	public Employee getActiveEmployees() {
		return null;
	}

	@Override
	public Employee getEmployee(String empId) {
		return null;
	}

	@Override
	public ResponseDTO addEmployee(EmployeeDTO employeeDTO) {
		ResponseDTO responseDTO = new ResponseDTO();
		Employee employee = employeeJpaRepository.save(employeeConverter.convert(employeeDTO));
		if(employee!=null)
			responseDTO.put("sucess", true);
		else
			responseDTO.put("sucess", false);
		return responseDTO;
	}

}