package org.esudarshan.restcontroller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.esudarshan.model.Employee;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class RestAPIController {

	public static List<Employee> employeeList = new ArrayList<Employee>(Arrays
			.asList(new Employee("sekambe", "se@gmail.com", null), new Employee("esudarshan", "es@gmail.com", null)));

	@RequestMapping(value = "/employees", method = RequestMethod.GET, produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE, })
	public List<Employee> getAllEmployees() {
		return employeeList;
	}

	@RequestMapping(value = "/employees/{name}")
	public ResponseEntity<Employee> getEmployee(@PathVariable("name") String name) {
		for (Employee employee : employeeList) {
			if (employee.getName().equals(name)) {
				return new ResponseEntity<>(employee, HttpStatus.OK);
			}
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/employees", method = RequestMethod.POST)
	public ResponseEntity<Void> addEmployee(@RequestBody Employee employee) {
		employeeList.add(employee);
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Location", ServletUriComponentsBuilder.fromCurrentRequest().path("/{name}")
				.buildAndExpand(employee.getName()).toUri().toString());
		return new ResponseEntity<>(httpHeaders, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/employees/{name}", method = RequestMethod.PUT, consumes = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Employee> updateEmployee(@PathVariable("name") String name, @RequestBody Employee employee) {
		for (Employee emp : employeeList) {
			if (emp.getName().equals(name)) {
				emp.setName(employee.getName());
				emp.setEmail(employee.getEmail());
				return new ResponseEntity<>(emp, HttpStatus.OK);
			}
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/employees/{name}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteEmployee(@PathVariable("name") String name) {
		int index = -1;
		for (Employee employee : employeeList) {
			if (employee.getName().equals(name)) {
				index = employeeList.indexOf(employee);
				break;
			}
		}
		if (index != -1) {
			employeeList.remove(index);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

}
