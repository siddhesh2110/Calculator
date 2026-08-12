package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Employee;
import com.app.service.EmployeeServiceI;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeServiceI esi;

	@PostMapping("/employee")
	public Employee saveEmployee(@RequestBody Employee employee) {

		Employee emp = esi.addEmployee(employee);

		return emp;
	}

	@GetMapping("/get")
	public List<Employee> getAllEmployee() {
		List<Employee> all = esi.getAll();
		return all;
	}

	@PutMapping("/update")
	public Employee updateEmployeeData(@RequestBody Employee employee) {
		Employee updateEmployee = esi.updateEmployee(employee);
		return updateEmployee;
	}

	@DeleteMapping("/delete/{id}")
	public List<Employee> deleteEmployee(@PathVariable("id") int id) {

		List<Employee> data = esi.deleteEmployeeData(id);
		return data;
	}
	
	@GetMapping("/single/{id}")
	public Employee getEmployee(@PathVariable("id") int id)
	{
	    Employee employee = esi.getSingleEmployee(id);
		return employee; 
	    
	}

   @GetMapping("/emp/{name}")	
	public List<Employee> getEmployeeByname(@PathVariable("name")String name){
		
	  List<Employee>list = esi.getEmployee(name); 
	   
	  
	   return list;
	   
   }
   @GetMapping("/login/{username}/{password}")
	public Employee loginCheck(@PathVariable("username") String un, @PathVariable("password") String ps)
	{
		Employee employee = esi.loginCheck(un, ps);
		return employee;
	}

   @DeleteMapping("delbyname/{name}")
	public List<Employee> deleteEmployee(@PathVariable("name") String name)
	{
	    List<Employee> list = esi.deleteEmployeeByname(name);
		return list;
	}
		
   @GetMapping("/pagging/{pageno}")
   public List<Employee> paggingEmployeeData(@PathVariable("pageno")int pageno){
	   
	   List<Employee> list = esi.pageingandsorting(pageno);
	   return list;
   }
	
}
