package com.nitinraj.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Query;

import org.hibernate.Session;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import com.nitinraj.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOImplementation implements EmployeeDAO {
	
	private EntityManager entityManager;
	
	@Autowired
	public EmployeeDAOImplementation(EntityManager theEntityManager) {
		entityManager=theEntityManager;
	}
	
	@Override
	public List<Employee> getAllEmployees() {
		
		Session currentSession=entityManager.unwrap(Session.class);
		
		Query<Employee> query=currentSession.createQuery("from Employee", Employee.class);
		
		List<Employee> employees=query.getResultList();
		
		return employees;
	}

	@Override
	public Employee getempById(int theID) {
		
		Session currentSession=entityManager.unwrap(Session.class);
		
		Employee theEmployee=currentSession.get(Employee.class, theID);
		
		return theEmployee;
	}

	@Override
	public void saveEmployee(Employee employee) {
		
		Session currentSession=entityManager.unwrap(Session.class);
		
		currentSession.saveOrUpdate(employee);
		
		
	}

	@Override
	public void deleteById(int theID) {
		
		Session currentSession=entityManager.unwrap(Session.class);
		
		Query query=currentSession.createQuery("delete from Employee where id=:employeeID");
		
		query.setParameter("employeeID", theID);
		
		query.executeUpdate();
		
	}

}
