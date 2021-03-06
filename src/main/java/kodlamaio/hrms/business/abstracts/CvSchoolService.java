package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.dataAccess.abstracts.CandidateCvSchoolDao;
import kodlamaio.hrms.entities.concretes.CandidateCvSchool;
import kodlamaio.hrms.entities.dtos.CandidateCvSchoolAddDto;

public interface CvSchoolService {
	DataResult<List<CandidateCvSchool>> getAll();
	DataResult<List<CandidateCvSchool>> findByCandidate_IdOrderByGradiationDateDesc(int id);
	Result  delete(int id);

}
