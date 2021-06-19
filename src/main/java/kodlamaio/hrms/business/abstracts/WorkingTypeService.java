package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.WorkingType;

public interface WorkingTypeService {
	Result add(WorkingType workingType);
	DataResult<List<WorkingType >> getAll();
}
