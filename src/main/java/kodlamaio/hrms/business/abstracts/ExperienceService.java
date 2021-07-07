package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CandidateCvExperience;
import kodlamaio.hrms.entities.dtos.CandidateCvExperienceAddDto;

public interface ExperienceService {
	DataResult<List<CandidateCvExperience>> getAll();
	 DataResult<List<CandidateCvExperience>> findByCandidate_IdOrderByStartDateDesc(int id);
	 
}
