package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.WorkingTypeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.WorkingTypeDao;
import kodlamaio.hrms.entities.concretes.WorkingType;
@Service
public class WorkingTypeManager implements WorkingTypeService{
	private WorkingTypeDao workingTypeDao;
	@Autowired
	public WorkingTypeManager(WorkingTypeDao workingTypeDao) {
		super();
		this.workingTypeDao = workingTypeDao;
	}
	@Override
	public Result add(WorkingType workingType) {
		this.workingTypeDao.save(workingType);
		return new SuccessResult("Added to System");
	}
	@Override
	public DataResult<List<WorkingType>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<WorkingType>>(this.workingTypeDao.findAll());
	}

}
