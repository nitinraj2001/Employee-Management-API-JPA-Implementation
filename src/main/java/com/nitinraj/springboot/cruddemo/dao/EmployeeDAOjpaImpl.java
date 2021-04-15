package com.nitinraj.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.nitinraj.springboot.cruddemo.entity.Employee;

@Repository(value="EmployeeDAOjpaImpl")
@Primary
public class EmployeeDAOjpaImpl implements EmployeeDAO {
	
	private EntityManager entityManager;
	
	@Autowired
	public EmployeeDAOjpaImpl(EntityManager theEntityManager) {
		entityManager=theEntityManager;
	}

	@Override
	public List<Employee> getAllEmployees() {
		
		Query thequery=entityManager.createQuery("from Employee");
		
		List<Employee> theEmployees=thequery.getResultList();
		
		return theEmployees;
	}

	@Override
	public Employee getempById(int theID) {
		
		Employee theEmployee=entityManager.find(Employee.class, theID);
		
		return theEmployee;
	}

	@Override
	public void saveEmployee(Employee employee) {
		
		Employee dbemployee=entityManager.merge(employee);
		
		employee.setId(dbemployee.getId());
		
		
		
	}

	@Override
	public void deleteById(int theID) {
		
		Query theQuery=entityManager.createQuery("delete from Employee where id=:empID");
		theQuery.setParameter("empID", theID);
		theQuery.executeUpdate();
		
		
	}

}
