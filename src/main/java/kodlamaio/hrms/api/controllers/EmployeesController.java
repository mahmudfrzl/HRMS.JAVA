package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import javax.transaction.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.EmployeeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employee;
@RestController
@RequestMapping("/api/employee")
@CrossOrigin
public class EmployeesController {
	private EmployeeService employeeService;
	@Autowired
	public EmployeesController(@RequestBody EmployeeService employeeService) {
		super();
		this.employeeService=employeeService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Employee>> getAll(){
		return this.employeeService.getAll();
	}
	@PostMapping("/add")
	public List<Result> add(@RequestBody Employee employee) {
		return this.employeeService.add(employee); 
	}
	@Transactional
	@PutMapping("/update")
	public List<Result> update(@RequestBody Employee employee) {
		return this.employeeService.update(employee);
	}
	@DeleteMapping("/delete")
	public Result delete(int id) {
		return this.employeeService.delete(id);
	}

}
