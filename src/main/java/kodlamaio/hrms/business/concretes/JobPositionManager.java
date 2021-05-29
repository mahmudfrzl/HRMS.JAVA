package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobPositionService;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.core.utilities.results.AllDataResult;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobPositionDao;
import kodlamaio.hrms.entities.concretes.JobPosition;
@Service
public class JobPositionManager implements JobPositionService{
  
	
	private JobPositionDao jobPositionDao;

 
 
	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao) {
		super();
		this.jobPositionDao = jobPositionDao;
	}
	@Override
	public DataResult<List<JobPosition> > getAll() {
		return new SuccessDataResult<List<JobPosition>>(jobPositionDao.findAll(), Messages.DataListed);
				
	}
	@Override
	public List<Result> add(JobPosition jobPosition) {
		AllDataResult allDataResult = new AllDataResult();
		allDataResult=checkAllFields(jobPosition);
		if(allDataResult.isSuccess()) {
		this.jobPositionDao.save(jobPosition);
		allDataResult.addResult(new SuccessResult(Messages.JobPositionAdded));
		return allDataResult.getSuccessResults();
		}
		else {
			return allDataResult.getErrorResults();
		}
		


	}
	@Override
	public boolean checkTitle(String title) {
		List<JobPosition> jobPositions = getAll().getData();
		for(JobPosition jobPosition :jobPositions ) {
			if(jobPosition.getTitle().equals(title)) {
				return false;
			}
		}
		return true;
	}
	@Override
	public AllDataResult checkAllFields(JobPosition jobPosition) {
		AllDataResult allDataResult = new AllDataResult();
		if(!checkTitle(jobPosition.getTitle())) {
			 allDataResult.addResult(new ErrorResult(Messages.ThisTitleIsAlreadyInTheSystem));
		}
		return allDataResult;
	}




}
