package com.example.au.couchbasedemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//import com.example.au.couchbasedemo.model.Blogs;
import com.example.au.couchbasedemo.model.Employee;
import com.example.au.couchbasedemo.repository.EmployeeRepository;

@RestController
public class EmployeeController{
	@Autowired
    EmployeeRepository employeeRepository;
	
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee newEmployee) {
		return employeeRepository.save(newEmployee);
	}
	
	@GetMapping("employees/address/{address}")
	public List<Employee> getEmployeeByaddress(@PathVariable String address) {
		return employeeRepository.findByAddress(address);
	}
	
	@GetMapping("employees/pincode/{pincode}")
	public List<Employee> getEmployeeBypincode(@PathVariable String pincode) {
		return employeeRepository.findBypincode(pincode);
	}
}