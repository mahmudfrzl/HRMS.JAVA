package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ExperienceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateCvExperienceDao;
import kodlamaio.hrms.entities.concretes.CandidateCvExperience;

@Service
public class CandidateCvExperienceManager implements ExperienceService{
	private CandidateCvExperienceDao candidateCvExperienceDao;
	@Autowired
	public CandidateCvExperienceManager(CandidateCvExperienceDao candidateCvExperienceDao) {
		super();
		this.candidateCvExperienceDao = candidateCvExperienceDao;
	}
	@Override
	public DataResult<List<CandidateCvExperience>> getAll() {
		
		return new SuccessDataResult<List<CandidateCvExperience>>(candidateCvExperienceDao.findAll(),"Data listelendi");
	}


}
