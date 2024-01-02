package com.crud.practice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.practice.dto.EmployeeDTO;
import com.crud.practice.entity.Employee;
import com.crud.practice.exception.EmployeeException;
import com.crud.practice.repository.EmployeeRepository;

import jakarta.transaction.Transactional;


@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
 EmployeeRepository employeeRepository;

	@Override
	public String addEmployee(EmployeeDTO employeeDTO) throws EmployeeException {
		// TODO Auto-generated method stub
		Optional<Employee> isExist= employeeRepository.findById(employeeDTO.getId());
		if(isExist.isPresent()) {
			throw new EmployeeException("Employee Already Exists");
		}
		Employee emp=new Employee();
		emp.setId( employeeDTO.getId());
		emp.setName( employeeDTO.getName());
		emp.setAddress( employeeDTO.getAddress());
		emp.setEmailId( employeeDTO.getEmailId());
		emp.setPhoneNo( employeeDTO.getPhoneNo());
		employeeRepository.save(emp);
	
	return "new employe suceesfully added";
	}
 
	@Override
	public EmployeeDTO getEmployee(int id) throws EmployeeException {
		Optional<Employee> isExist = employeeRepository.findById(id);
		// TODO Auto-generated method stub
		Employee employee = isExist.orElseThrow(()-> new EmployeeException("Employee not found"));
		 EmployeeDTO emp=new EmployeeDTO();
		 emp.setEmailId(employee.getEmailId());
		 emp.setAddress(employee.getAddress());
		 emp.setName(employee.getName());
		 emp.setPhoneNo(employee.getPhoneNo());
		 emp.setId(employee.getId());
		 return emp ;	
	}
	 

	@Override
	public List<EmployeeDTO> getAllEmployees() throws EmployeeException{
	Iterable<Employee> list = employeeRepository.findAll();
	List<EmployeeDTO> newList=new ArrayList<>();
	list.forEach(c->{
		EmployeeDTO emp= new EmployeeDTO();
		emp.setEmailId(c.getEmailId());
		 emp.setAddress(c.getAddress());
		 emp.setName(c.getName());
		 emp.setPhoneNo(c.getPhoneNo());
		 emp.setId(c.getId());
		 newList.add(emp);
	});
	if(newList.isEmpty()) {
		throw new EmployeeException("No employees found");
	}
		// TODO Auto-generated method stub
		
		return newList;
	}

	@Override
	public String deleteEmployee(int id) throws EmployeeException {
		// TODO Auto-generated method stub
		
		Optional<Employee> isExist = employeeRepository.findById(id);
		isExist.orElseThrow(()-> new  EmployeeException("Employee not found" ));
		employeeRepository.deleteById(id);
		return "Employee successfully deleted";
	}

	@Override
	public String  updateEmployee(int id, EmployeeDTO emp) throws EmployeeException {
	
		// TODO Auto-generated method stub
		Optional<Employee> isExist = employeeRepository.findById(id);
		Employee emps=isExist .orElseThrow(()->new EmployeeException("Employee not found"));
		emps.setId(emp.getId());
		emps.setName(emp.getName());
		emps.setAddress(emp.getAddress());
		emps.setEmailId(emp.getEmailId());
		emps.setPhoneNo(emp.getPhoneNo());
	return  "employee succesfuuly updated";	
	}
	
}
