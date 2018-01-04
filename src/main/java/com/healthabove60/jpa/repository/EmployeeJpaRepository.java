package com.healthabove60.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.healthabove60.jpa.entity.Employee;

public interface EmployeeJpaRepository extends JpaRepository<Employee, Integer>{
	
}