package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CvSchoolService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateCvSchoolDao;
import kodlamaio.hrms.entities.concretes.CandidateCvSchool;

@Service
public class CandidateCvSchoolManager implements CvSchoolService{
	private CandidateCvSchoolDao candidateCvSchoolDao;
	@Autowired
	public CandidateCvSchoolManager(CandidateCvSchoolDao candidateCvSchoolDao) {
		super();
		this.candidateCvSchoolDao = candidateCvSchoolDao;
	}
	@Override
	public DataResult<List<CandidateCvSchool>> getAll() {
		
		return new SuccessDataResult<List<CandidateCvSchool>>(this.candidateCvSchoolDao.findAll());
	}

}
