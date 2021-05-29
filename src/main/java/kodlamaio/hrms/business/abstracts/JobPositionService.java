package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.AllDataResult;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobPosition;

public interface JobPositionService {	
	DataResult<List<JobPosition>>  getAll();
	List<Result>  add(JobPosition jobPosition);
	AllDataResult checkAllFields(JobPosition jobPosition);
	public boolean checkTitle(String title);

}
