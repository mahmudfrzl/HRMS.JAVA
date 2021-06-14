package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.AllDataResult;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employee;


public interface EmployeeService {
	DataResult<List<Employee>> getAll();
	List<Result> add(Employee employee);
	public Result delete(int id);
	AllDataResult checkALlFields(Employee employee);
	public boolean checkEmail(String email);
	public boolean checkPassword(String password) ;
	
	/*
	 * public boolean checkEmail(String email) ; AllDataResult
	 * checkAllFields(Employee employee);
	 */
	
	
}
