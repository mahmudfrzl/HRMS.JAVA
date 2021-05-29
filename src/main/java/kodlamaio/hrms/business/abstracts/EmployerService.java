package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.AllDataResult;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;

import kodlamaio.hrms.entities.concretes.Employer;

public interface EmployerService {
	DataResult<List<Employer>> getAll();
	List<Result> add(Employer employer);
	AllDataResult checkAllFields(Employer employer);
	boolean checkEmail(String email);
	public void emailVerification();

}
