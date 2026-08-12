package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.autoconfigure.web.DataWebProperties.Sort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.app.model.Employee;
import com.app.repository.EmployeeRepository;


@Service
public class EmployeeService implements EmployeeServiceI {

	@Autowired
	private EmployeeRepository er;
	
	@Override
	public Employee addEmployee(Employee employee) {
		Employee emp = er.save(employee);
		return emp;
	}

	@Override
	public List<Employee> getAll() {
		List<Employee> all = (List<Employee>) er.findAll();
		return all;
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		Employee updatedData = er.save(employee);
		return updatedData;
	}

	@Override
	public List<Employee> deleteEmployeeData(int id) {
		er.deleteById(id);
		List<Employee> all = (List<Employee>) er.findAll();
		
		return all;
	}

	@Override
	public Employee getSingleEmployee(int id) {
		Optional<Employee>op = er.findById(id);
		if(op.isPresent()) {
			Employee employee = op.get();
		return employee;
		}
		return null;
	}

	@Override
	public List<Employee> getEmployee(String name) {
		
		List<Employee> list = er.findByName(name);
		
		return list;
	}

	@Override
	public Employee loginCheck(String un, String ps) {
		
 		Employee employee = er.findByUsernameAndPassword(un, ps);
// 		Employee employee = er.findByUsernameOrPassword(un, ps);
		
		return employee;
	}


	@Override
	public List<Employee> deleteEmployeeByname(String name) {
		er.deleteByName(name);
		
		return (List<Employee>) er.findAll();
	}


	public List<Employee> pageingandsorting(int pageno){
		
		int size = 3;
		
		PageRequest pr = PageRequest.of(pageno, size);
		Page<Employee> page = er.findAll(pr);
		List<Employee> list = page.getContent();
      return list;
	}
	
	
}
