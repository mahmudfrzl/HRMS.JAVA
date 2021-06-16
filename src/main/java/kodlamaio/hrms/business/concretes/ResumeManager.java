package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ResumeService;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateCvCovverLetterDao;
import kodlamaio.hrms.dataAccess.abstracts.CandidateCvExperienceDao;
import kodlamaio.hrms.dataAccess.abstracts.CandidateCvLanguageDao;
import kodlamaio.hrms.dataAccess.abstracts.CandidateCvLinkDao;
import kodlamaio.hrms.dataAccess.abstracts.CandidateCvSchoolDao;
import kodlamaio.hrms.dataAccess.abstracts.CandidateCvTechnelogyDao;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.dataAccess.abstracts.PhotoDao;
import kodlamaio.hrms.dataAccess.abstracts.ResumeDao;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.dtos.ResumeDto;
@Service
public class ResumeManager implements ResumeService{
	private ResumeDao resumeDao;
	private CandidateDao candidateDao;
	private CandidateCvExperienceDao candidateCvExperienceDao;
	private CandidateCvLanguageDao languageDao;
	private CandidateCvTechnelogyDao technelogyDao;
	private CandidateCvSchoolDao schoolDao;
	private CandidateCvCovverLetterDao covverLetterDao;
	private CandidateCvLinkDao linkDao; 
	private PhotoDao photoDao;
	@Autowired
	public ResumeManager(ResumeDao resumeDao,CandidateDao candidateDao,
			CandidateCvExperienceDao candidateCvExperienceDao,
			CandidateCvLanguageDao languageDao,CandidateCvTechnelogyDao technelogyDao,
			CandidateCvSchoolDao schoolDao,CandidateCvCovverLetterDao covverLetterDao,
			CandidateCvLinkDao linkDao,
			PhotoDao photoDao) {
		super();
		this.resumeDao = resumeDao;
		this.candidateDao=candidateDao;
		this.candidateCvExperienceDao = candidateCvExperienceDao;
		this.languageDao = languageDao;
		this.covverLetterDao = covverLetterDao;
		this.schoolDao = schoolDao;
		this.technelogyDao = technelogyDao;
		this.linkDao = linkDao;
		this.photoDao=photoDao;
	}
	@Override
	public DataResult<ResumeDto> getAll(int candidateId) {
		Candidate candidate = new Candidate();
		candidate = candidateDao.findById(candidateId).get();
		ResumeDto resumeDto = new ResumeDto();
		resumeDto.setEmail(candidate.getEmail());
		resumeDto.setCandidatePhoto(candidate.getCandidatePhoto());
		resumeDto.setFirstName(candidate.getFirstName());
		resumeDto.setLastName(candidate.getLastName());
		resumeDto.setExperiences(this.candidateCvExperienceDao.findByCandidateId(candidateId));
		resumeDto.setLanguages(this.languageDao.findByCandidateId(candidateId));
		resumeDto.setTechnelogies(this.technelogyDao.findByCandidateId(candidateId));
		resumeDto.setLinks(this.linkDao.findByCandidateId(candidateId));
		resumeDto.setSchools(this.schoolDao.findByCandidateId(candidateId));
		resumeDto.setPhoto(this.photoDao.findByCandidateId(candidateId));
		resumeDto.setCovverLetter(this.covverLetterDao.findByCandidateId(candidateId));
		return new SuccessDataResult<ResumeDto>(resumeDto);
	}
	


}
