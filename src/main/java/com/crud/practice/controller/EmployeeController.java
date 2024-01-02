package com.crud.practice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.practice.dto.EmployeeDTO;
import com.crud.practice.exception.EmployeeException;
import com.crud.practice.service.EmployeeService;

@RestController
  @RequestMapping("/api") 
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/add")
	public  String addEmployee(@RequestBody EmployeeDTO employeeDTO)throws  EmployeeException {
		  
		return employeeService.addEmployee(employeeDTO);
	}
	
	@GetMapping("/get/{id}")
	public EmployeeDTO getEmployee(@PathVariable int id)throws EmployeeException {
		
		return employeeService.getEmployee(id);
	}
	@GetMapping("/getAll")
	public List<EmployeeDTO> getAllEmployees() throws EmployeeException {
		return employeeService.getAllEmployees();
	}
	@PutMapping("/update/{id}/emp")
	public String updateEmployee(@PathVariable int id , @RequestBody EmployeeDTO emp)throws EmployeeException {
		return employeeService.updateEmployee(id, emp);
	}
	@DeleteMapping("/del/{id}")
	public String deleteEmployee (@PathVariable int id)throws EmployeeException {
		return employeeService.deleteEmployee(id);
	}
	 

	
}
