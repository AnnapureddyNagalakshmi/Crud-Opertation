package com.crud.practice.service;

import java.util.List;

import com.crud.practice.dto.EmployeeDTO;
import com.crud.practice.exception.EmployeeException;

public interface  EmployeeService {
	public String addEmployee(EmployeeDTO employeeDTO)throws  EmployeeException;
	public EmployeeDTO getEmployee(int id)throws EmployeeException;
	public List<EmployeeDTO> getAllEmployees() throws EmployeeException;
	public String updateEmployee(int id ,EmployeeDTO emp)throws EmployeeException;
	public String deleteEmployee (int id)throws EmployeeException;
	 
}
