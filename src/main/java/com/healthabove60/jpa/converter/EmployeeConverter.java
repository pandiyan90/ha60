package com.healthabove60.jpa.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.healthabove60.dto.EmployeeDTO;
import com.healthabove60.jpa.entity.Employee;
import com.healthabove60.jpa.entity.User;
import com.healthabove60.jpa.repository.UserJpaRepository;

@Component
public class EmployeeConverter {

	@Autowired
	private UserJpaRepository userJpaRepository;
	
	public Employee convert(EmployeeDTO employeeDTO){
		Employee employee = new Employee();
		User user = userJpaRepository.findByUserId("Alex");
		employee.setUser(user);
		employee.setFirstName(employeeDTO.getFirstName());
		employee.setLastName(employeeDTO.getLastName());
		employee.setEmail(employeeDTO.getEmail());
		employee.setMobile(employeeDTO.getMobile());
		employee.setIsActive(true);
		employee.setIsDeleted(false);
		return employee;
	}
	
}