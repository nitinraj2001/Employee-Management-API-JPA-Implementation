package com.nitinraj.springboot.cruddemo.dao;

import java.util.List;

import org.springframework.context.annotation.Primary;

import com.nitinraj.springboot.cruddemo.entity.Employee;

@Primary
public interface EmployeeDAO {
	
	public List<Employee> getAllEmployees();
	
	public Employee getempById(int theID);
	
	public void saveEmployee(Employee employee);
	
	public void deleteById(int theID);
	

}
