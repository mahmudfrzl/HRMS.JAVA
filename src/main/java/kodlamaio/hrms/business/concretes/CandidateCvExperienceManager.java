package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ExperienceService;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateCvExperienceDao;
import kodlamaio.hrms.entities.concretes.CandidateCvExperience;
import kodlamaio.hrms.entities.dtos.CandidateCvExperienceAddDto;

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
		
		return new SuccessDataResult<List<CandidateCvExperience>>(candidateCvExperienceDao.findAll(),Messages.DataListed);
	}
	@Override
	public DataResult<List<CandidateCvExperience>> findByCandidate_IdOrderByStartDateDesc(int id) {
		
		return new SuccessDataResult<List<CandidateCvExperience>>(this.candidateCvExperienceDao.findByCandidate_IdOrderByStartDateDesc(id),Messages.candidateCvExperience);
	}



}
