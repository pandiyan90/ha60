package com.healthabove60.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.healthabove60.dto.EmployeeDTO;
import com.healthabove60.dto.ResponseDTO;
import com.healthabove60.jpa.entity.Employee;
import com.healthabove60.service.EmployeeService;

@RestController
@RequestMapping("/admin")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/all")
	public List<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();
	}

	@PostMapping("/addEmployee")
	public ResponseDTO addEmployee(@RequestBody EmployeeDTO employeeDTO, HttpServletRequest request) {
		return employeeService.addEmployee(employeeDTO);
	}

}