package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.WorkingTime;

public interface WorkingTimeService {
	Result add(WorkingTime workingTime);
	DataResult<List<WorkingTime> >  getAll();
}
