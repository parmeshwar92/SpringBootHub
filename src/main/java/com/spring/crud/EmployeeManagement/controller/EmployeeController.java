package com.spring.crud.EmployeeManagement.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.crud.EmployeeManagement.exception.ResourceNotFoundException;
import com.spring.crud.EmployeeManagement.model.Employee;
import com.spring.crud.EmployeeManagement.repository.EmployeeRepository;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
		List<Employee> employees= employeeRepository.findAll();
		return employees;
	}

	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long employeeId)
			throws ResourceNotFoundException {
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
		return ResponseEntity.ok().body(employee);
	}

	@PostMapping("/employees")
	public Employee createEmployee(@Valid @RequestBody Employee employee) {
		return employeeRepository.save(employee);
	}

	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long employeeId,
			@Valid @RequestBody Employee employeeDetails) throws ResourceNotFoundException {
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));

		employee.setEmailId(employeeDetails.getEmailId());
		employee.setLastName(employeeDetails.getLastName());
		employee.setFirstName(employeeDetails.getFirstName());
		employee.setBanksDetails(employeeDetails.getBanksDetails());
		employee.setUserProfile(employeeDetails.getUserProfile());
		final Employee updatedEmployee = employeeRepository.save(employee);
		return ResponseEntity.ok(updatedEmployee);
	}

	@DeleteMapping("/employees/{id}")
	public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long employeeId)
			throws ResourceNotFoundException {
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));

		employeeRepository.delete(employee);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	/*
	 * @Autowired private EmployeeRepository employeeRepository;
	 */

	/*
	 * @Autowired private EmployeeService employeeService;
	 * 
	 * @GetMapping("/employees") public List<Employee> getAllEmployees() { return
	 * employeeService.findAll(); }
	 * 
	 * @GetMapping("/employees/{id}") public ResponseEntity<Employee>
	 * getEmployeeById(@PathVariable(value = "id") Long employeeId) throws
	 * ResourceNotFoundException { Employee employee =
	 * employeeService.findById(employeeId); if(employee == null) { throw new
	 * ResourceNotFoundException("Employee not found for this id :: " + employeeId);
	 * } // .orElseThrow(() -> new
	 * ResourceNotFoundException("Employee not found for this id :: " +
	 * employeeId)); return ResponseEntity.ok().body(employee); }
	 * 
	 * @PostMapping("/employees") public Employee createEmployee(@Valid @RequestBody
	 * Employee employee) { return employeeService.save(employee); }
	 * 
	 * @PutMapping("/employees/{id}") public ResponseEntity<Employee>
	 * updateEmployee(@PathVariable(value = "id") Long employeeId,
	 * 
	 * @Valid @RequestBody Employee employeeDetails) throws
	 * ResourceNotFoundException { Employee employee =
	 * employeeService.findById(employeeId); if(employee == null) { throw new
	 * ResourceNotFoundException("Employee not found for this id :: " + employeeId);
	 * } //.orElseThrow(() -> new
	 * ResourceNotFoundException("Employee not found for this id :: " +
	 * employeeId));
	 * 
	 * employee.setEmailId(employeeDetails.getEmailId());
	 * employee.setLastName(employeeDetails.getLastName());
	 * employee.setFirstName(employeeDetails.getFirstName()); final Employee
	 * updatedEmployee = employeeService.save(employee); return
	 * ResponseEntity.ok(updatedEmployee); }
	 * 
	 * @DeleteMapping("/employees/{id}") public Map<String, Boolean>
	 * deleteEmployee(@PathVariable(value = "id") Long employeeId) throws
	 * ResourceNotFoundException { Employee employee =
	 * employeeService.findById(employeeId); if(employee == null) { throw new
	 * ResourceNotFoundException("Employee not found for this id :: " + employeeId);
	 * } // .orElseThrow(() -> new
	 * ResourceNotFoundException("Employee not found for this id :: " +
	 * employeeId));
	 * 
	 * employeeService.delete(employee); Map<String, Boolean> response = new
	 * HashMap<>(); response.put("deleted", Boolean.TRUE); return response; }
	 */
}
