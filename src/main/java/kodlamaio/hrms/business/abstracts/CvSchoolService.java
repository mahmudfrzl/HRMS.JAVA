package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateCvSchoolDao;
import kodlamaio.hrms.entities.concretes.CandidateCvSchool;

public interface CvSchoolService {
	DataResult<List<CandidateCvSchool>> getAll();
}
