package com.app.service;

import java.util.List;

import com.app.model.Employee;

public interface EmployeeServiceI {

	public Employee addEmployee(Employee employee);
	public List<Employee> getAll();
	public Employee updateEmployee(Employee employee);
	public List<Employee> deleteEmployeeData(int id);
    public Employee getSingleEmployee(int id);
    public List<Employee> getEmployee(String name);
    public Employee loginCheck(String un, String ps);
    public List<Employee> deleteEmployeeByname(String name);
	public List<Employee> pageingandsorting(int pageno);

}

