
package com.ruthvik.CRUD.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ruthvik.CRUD.model.Employee;
import com.ruthvik.CRUD.repository.EmployeeRepo;

@RestController
@CrossOrigin(origins = "http://localhost:5174")
public class EmployeeController {

	@Autowired
	EmployeeRepo employeeRepo;

	// http://localhost:9991/hello
	// @GetMapping("/hello")
	// String hello() {
	// return "hello Welcome to SPRING WORKSHOP";
	// }

	// http://localhost:9991/getEmpList - GET ALL EMPLOYEES
	@GetMapping("/getEmpList")
	List<Employee> getAllEmployeeDetails() {
		return employeeRepo.findAll();
	}

	// http://localhost:9991/getEmp/1 - GET EMPLOYEE BY ID
	@GetMapping("/getEmp/{eid}")
	Employee getEmployee(@PathVariable Integer eid) {
		return employeeRepo.findById(eid).orElseThrow();
	}

	// http://localhost:9991/createEmp - CREATE EMPLOYEE
	@PostMapping("/createEmp")
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeRepo.save(employee);
	}

	// Create multiple employees at once
	// @PostMapping("/createEmp")
	// public List<Employee> createEmployees(@RequestBody List<Employee> employees)
	// {
	// return employeeRepo.saveAll(employees);
	// }

	// http://localhost:9991/updateEmp/1 - UPDATE EMPLOYEE
	@PutMapping("/updateEmp/{eid}")
	Employee updateEmployee(@RequestBody Employee employee, @PathVariable Integer eid) {

		Employee empFromDb = employeeRepo.findById(eid).orElseThrow();

		empFromDb.setEname(employee.getEname());
		empFromDb.setDesignation(employee.getDesignation());
		empFromDb.setAge(employee.getAge());
		empFromDb.setWorkPlace(employee.getWorkPlace());

		return employeeRepo.save(empFromDb);
	}

	// http://localhost:9991/delEmp/1 - DELETE EMPLOYEE
	@DeleteMapping("/delEmp/{eid}")
	String deleteEmployee(@PathVariable Integer eid) {

		employeeRepo.deleteById(eid);

		return "Employee has been deleted successfully with id of " + eid;
	}
}
