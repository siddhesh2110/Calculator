package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.model.Employee;

import jakarta.transaction.Transactional;

import java.util.List;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>
{

	public List<Employee> findByName(String name);
	
	public Employee findByUsernameAndPassword(String un , String ps);


	@Transactional
	@Modifying
	public void  deleteByName(String name);

	public List<Employee> getAll();
}
