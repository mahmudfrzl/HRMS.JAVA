package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CvSchoolService;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.core.utilities.results.AllDataResult;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateCvSchoolDao;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.dataAccess.abstracts.SchoolDao;
import kodlamaio.hrms.entities.concretes.CandidateCvSchool;
import kodlamaio.hrms.entities.dtos.CandidateCvSchoolAddDto;

@Service
public class CandidateCvSchoolManager implements CvSchoolService{
	private CandidateCvSchoolDao candidateCvSchoolDao;
	private CandidateDao candidateDao;
	private SchoolDao schoolDao;
	@Autowired
	public CandidateCvSchoolManager(CandidateCvSchoolDao candidateCvSchoolDao,
			CandidateDao candidateDao,
			SchoolDao schoolDao) {
		super();
		this.candidateCvSchoolDao = candidateCvSchoolDao;
		this.candidateDao = candidateDao;
		this.schoolDao = schoolDao;
	}
	@Override
	public DataResult<List<CandidateCvSchool>> getAll() {
		
		return new SuccessDataResult<List<CandidateCvSchool>>(this.candidateCvSchoolDao.findAll());
	}
	@Override
	public DataResult<List<CandidateCvSchool>> findByCandidate_IdOrderByGradiationDateDesc(int id) {
		
		return new SuccessDataResult<List<CandidateCvSchool>>(this.candidateCvSchoolDao.findByCandidate_IdOrderByGradiationDateDesc(id), Messages.candidateCvSchoolGradiationDateDesc);
	}
	@Override
	public Result delete(int id) {
		
		this.candidateCvSchoolDao.deleteById(id);
		return new SuccessResult();
	}


}
