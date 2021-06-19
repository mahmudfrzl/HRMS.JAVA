package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.WorkingTimeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.WorkingTimeDao;
import kodlamaio.hrms.entities.concretes.WorkingTime;
@Service
public class WorkingTimeManager implements WorkingTimeService{
	private WorkingTimeDao workingTimeDao;
	@Autowired
	public WorkingTimeManager(WorkingTimeDao workingTimeDao) {
		super();
		this.workingTimeDao = workingTimeDao;
	}
	@Override
	public Result add(WorkingTime workingTime) {
		this.workingTimeDao.save(workingTime);
		
		return new SuccessResult("Added to System");
	}
	@Override
	public DataResult<List<WorkingTime>> getAll() {
		
		return new SuccessDataResult<List<WorkingTime>>(this.workingTimeDao.findAll());
	}
	
}
