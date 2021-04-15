package com.nitinraj.springboot.cruddemo.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nitinraj.springboot.cruddemo.dao.EmployeeDAO;

import com.nitinraj.springboot.cruddemo.entity.Employee;

@Transactional
@Service
public class EmployeeServiceImplementation implements EmployeeService {
	
	private EmployeeDAO theEmployeeDao;
	
	public EmployeeServiceImplementation(EmployeeDAO EmployeeDao) {
		theEmployeeDao=EmployeeDao;
	}

	@Override
	public List<Employee> getAllEmployees() {
		
		return theEmployeeDao.getAllEmployees();
	}

	@Override
	public Employee getempById(int theID) {
		
		return theEmployeeDao.getempById(theID);
	}

	@Override
	public void saveEmployee(Employee employee) {
		
		theEmployeeDao.saveEmployee(employee);
		
	}

	@Override
	public void deleteById(int theID) {
		
		theEmployeeDao.deleteById(theID);
		
		
	}

}
