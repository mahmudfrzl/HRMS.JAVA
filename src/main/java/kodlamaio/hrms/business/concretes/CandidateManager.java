package kodlamaio.hrms.business.concretes;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.base.Strings;

import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.business.abstracts.ActivationCodeService;
import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.core.utilities.adapters.EmailService;
import kodlamaio.hrms.core.utilities.adapters.MernisService;
import kodlamaio.hrms.core.utilities.results.AllDataResult;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.dataAccess.abstracts.JobPositionDao;
import kodlamaio.hrms.dataAccess.abstracts.CandidateCvCovverLetterDao;
import kodlamaio.hrms.dataAccess.abstracts.CandidateCvExperienceDao;
import kodlamaio.hrms.dataAccess.abstracts.CandidateCvLanguageDao;
import kodlamaio.hrms.dataAccess.abstracts.CandidateCvLinkDao;
import kodlamaio.hrms.dataAccess.abstracts.CandidateCvSchoolDao;
import kodlamaio.hrms.dataAccess.abstracts.CandidateCvTechnelogyDao;
import kodlamaio.hrms.dataAccess.abstracts.SchoolDao;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.CandidateCvCovverLetter;
import kodlamaio.hrms.entities.concretes.CandidateCvExperience;
import kodlamaio.hrms.entities.concretes.CandidateCvLanguage;
import kodlamaio.hrms.entities.concretes.CandidateCvLink;
import kodlamaio.hrms.entities.concretes.CandidateCvSchool;
import kodlamaio.hrms.entities.concretes.CandidateCvTechnelogy;
import kodlamaio.hrms.entities.dtos.CandidateCVTechnelogyAddDto;
import kodlamaio.hrms.entities.dtos.CandidateCvCovverLetterAddDto;
import kodlamaio.hrms.entities.dtos.CandidateCvExperienceAddDto;
import kodlamaio.hrms.entities.dtos.CandidateCvLanguageDto;
import kodlamaio.hrms.entities.dtos.CandidateCvLinkAddDto;
import kodlamaio.hrms.entities.dtos.CandidateCvSchoolAddDto;

@Service

public class CandidateManager implements CandidateService{
	
	private CandidateDao candidateDao;
	private EmailService emailService;
	private MernisService mernisService;
	private ActivationCodeService activationCodeService;
	private SchoolDao schoolDao;
	private CandidateCvSchoolDao candidateCvSchoolDao;
	private CandidateCvExperienceDao candidateCvExperienceDao;
	private JobPositionDao jobPositionDao;
	private CandidateCvLanguageDao candidateCvLanguageDao;
	private CandidateCvLinkDao candidateCvLinkDao;
	private CandidateCvTechnelogyDao candidateCvTechnelogyDao;
	private CandidateCvCovverLetterDao candidateCvCovverLetterDao;
	
	

	@Autowired
	public CandidateManager(CandidateDao candidateDao,EmailService emailService,
			ActivationCodeService activationCodeService,
			MernisService mernisService,SchoolDao schoolDao,
			CandidateCvSchoolDao candidateCvSchoolDao,
			CandidateCvExperienceDao candidateCvExperienceDao,JobPositionDao jobPositionDao
			,CandidateCvLanguageDao candidateCvLanguageDao,
			CandidateCvLinkDao candidateCvLinkDao,CandidateCvTechnelogyDao candidateCvTechnelogyDao,
			CandidateCvCovverLetterDao candidateCvCovverLetterDao) {
		super();
		this.candidateDao = candidateDao;
		this.emailService=emailService;
		this.activationCodeService = activationCodeService;
		this.mernisService=mernisService;
		this.schoolDao = schoolDao;
		this.candidateCvSchoolDao = candidateCvSchoolDao;
		this.candidateCvExperienceDao = candidateCvExperienceDao;
		this.jobPositionDao = jobPositionDao;
		this.candidateCvLanguageDao = candidateCvLanguageDao;
		this.candidateCvLinkDao = candidateCvLinkDao;
		this.candidateCvTechnelogyDao = candidateCvTechnelogyDao;
		this.candidateCvCovverLetterDao = candidateCvCovverLetterDao;
	}

	@Override
	public DataResult<List<Candidate>> getAll() {
		
		return new SuccessDataResult<List<Candidate>>( this.candidateDao.findAll(), Messages.DataListed   ) ;
	}

	@Override
	public List<Result> add(Candidate candidate) {
		AllDataResult allDataResult = new AllDataResult();
		
		allDataResult=checkAllFields(candidate);
		if(allDataResult.isSuccess()==false) {
			
			emailService.isOkay(candidate.getEmail());
			allDataResult.addResult(new SuccessResult());
			mernisService.isOkay(candidate.getIdentityNumber());
			allDataResult.addResult(new SuccessResult(Messages.mernisAuthentication));
			this.candidateDao.save(candidate);
			allDataResult.addResult(new SuccessResult(Messages.RegisterSuccess));
			activationCodeService.sendActivationCode(candidate.getId());
			allDataResult.addResult(new SuccessResult(Messages.generatedActivationCode));

			return allDataResult.getSuccessResults();
		}else {
			
			return allDataResult.getErrorResults();
			
		}
		
	}

	@Override
	public AllDataResult checkAllFields(Candidate candidate) {
		AllDataResult allDataResult = new AllDataResult();
		
	
		if(Strings.isNullOrEmpty(candidate.getEmail())==true){
			allDataResult.addResult(new ErrorResult(Messages.emailIsEmpty));
		} 
		if(Strings.isNullOrEmpty(candidate.getFirstName())==true){
			allDataResult.addResult(new ErrorResult(Messages.nameIsEmpty));
		}
		if(Strings.isNullOrEmpty(candidate.getLastName())==true){
			allDataResult.addResult(new ErrorResult(Messages.lastNameIsEmpty));
		}
		if(Strings.isNullOrEmpty(candidate.getIdentityNumber())==true){
			allDataResult.addResult(new ErrorResult(Messages.identityNumberIsEmpty));
		}
		if(Strings.isNullOrEmpty(candidate.getPassword())==true){
			allDataResult.addResult(new ErrorResult(Messages.passwordIsEmpty));
		}
		if(candidate.getBirthDate() == null) {
			allDataResult.addResult(new ErrorResult(Messages.birthDayIsEmpty));
		}
		if(!emailService.isOkay(candidate.getEmail())) {
			allDataResult.addResult(new ErrorResult(Messages.wrogEmail));
		}
		if(!checkEmail(candidate.getEmail())) {
			allDataResult.addResult(new ErrorResult(Messages.ThisEmailAddressIsUsed));
		}
		if(!checkPassword(candidate.getPassword())) {
			allDataResult.addResult(new ErrorResult(Messages.ThisPasswordAddressIsUsed));
		}
		if(!checkIdentityCode(candidate.getIdentityNumber())) {
			allDataResult.addResult(new ErrorResult(Messages.ThisNationalIdIsUsed));
		}
		

			
		return allDataResult;
	}

	@Override
	public boolean checkEmail(String email) {
		List<Candidate> candidates = getAll().getData();
		for(Candidate candidate : candidates) {
				if(candidate.getEmail().equals(email)) {
					return false;
				}				
		}
	
		return true;
	}

	@Override
	public boolean checkPassword(String password) {
		List<Candidate> candidates = getAll().getData();
		for(Candidate candidate : candidates) {
				if(candidate.getPassword().equals(password)) {
					return false;
				}				
		}
	
		return true;
	}

	@Override
	public boolean checkIdentityCode(String identityNumber) {
		List<Candidate> candidates = getAll().getData();
		for(Candidate candidate : candidates) {
				if(candidate.getIdentityNumber().equals(identityNumber)) {
					return false;
				}				
		}
	
		return true;
	}

	@Override
	public void emailVerification(int id) {
		this.activationCodeService.sendActivationCode(id);
		
	}

	@Override
	public void mernisVerification(String identityNumber) {
		mernisService.isOkay(identityNumber);
		
	}

	@Override
	public DataResult<List<Candidate>> getById(int id) {
			
		this.candidateDao.getOne(id);
		return new SuccessDataResult<List<Candidate>>();
	}


	
	@Override
	public List<Result> addSchool(CandidateCvSchoolAddDto cvSchoolAddDto) {
		AllDataResult allDataResult = new AllDataResult();
		CandidateCvSchool candidateCvSchool = new CandidateCvSchool();
		candidateCvSchool.setCandidate(candidateDao.findById(cvSchoolAddDto.getCandidateId()).get());
		candidateCvSchool.setSchool(schoolDao.findById(cvSchoolAddDto.getSchoolId()).get());
		candidateCvSchool.setSchoolDepartment(cvSchoolAddDto.getDepartment());
		candidateCvSchool.setStartDate(cvSchoolAddDto.getStartDate());
		candidateCvSchool.setGradiationDate(cvSchoolAddDto.getGradiationDate());
		this.candidateCvSchoolDao.save(candidateCvSchool);
		allDataResult.addResult(new SuccessResult(Messages.candidateCvSchool));
		return allDataResult.getSuccessResults();
		
	}

	@Override
	public List<Result> addExperience(CandidateCvExperienceAddDto cvExperienceAddDto) {
		AllDataResult allDataResult = new AllDataResult();
		CandidateCvExperience candidateCvExperience = new CandidateCvExperience();
		candidateCvExperience.setCandidate(candidateDao.findById(cvExperienceAddDto.getCandidateId()).get());
		candidateCvExperience.setJobPositions(jobPositionDao.findById(cvExperienceAddDto.getJobPositionId()).get());
		candidateCvExperience.setQuitDate(cvExperienceAddDto.getQuitDate());
		candidateCvExperience.setStartDate(cvExperienceAddDto.getStartDate());
		candidateCvExperience.setWorkPlaceName(cvExperienceAddDto.getWorkPlaceName());
		this.candidateCvExperienceDao.save(candidateCvExperience);
		allDataResult.addResult(new SuccessResult(Messages.candidateCvExperience));
		return allDataResult.getSuccessResults();
	}

	@Override
	public List<Result> addLanguage(CandidateCvLanguageDto cvLanguageDto) {
		AllDataResult allDataResult = new AllDataResult();
		CandidateCvLanguage candidateCvLanguage = new CandidateCvLanguage();
		candidateCvLanguage.setCandidate(candidateDao.findById(cvLanguageDto.getCandidateId()).get());
		candidateCvLanguage.setName(cvLanguageDto.getName());
		candidateCvLanguage.setLanguageLevel(cvLanguageDto.getLanguageLevel());
		this.candidateCvLanguageDao.save(candidateCvLanguage);
		allDataResult.addResult(new SuccessResult(Messages.candidateCvLanguage));
		return allDataResult.getSuccessResults();
	}

	@Override
	public List<Result> addLink(CandidateCvLinkAddDto cvLinkAddDto) {
		AllDataResult allDataResult = new AllDataResult();
		CandidateCvLink candidateCvLink = new CandidateCvLink();
		candidateCvLink.setCandidate(candidateDao.findById(cvLinkAddDto.getCandidateId()).get());
		candidateCvLink.setActive(cvLinkAddDto.isActive());
		candidateCvLink.setGithubLink(cvLinkAddDto.getGithubLink());
		candidateCvLink.setLinkedinLink(cvLinkAddDto.getLinkedinLink());
		this.candidateCvLinkDao.save(candidateCvLink);
		allDataResult.addResult(new SuccessResult(Messages.candidateCvLinks));
		return allDataResult.getSuccessResults();
	}

	@Override
	public List<Result> addTechnelogy(CandidateCVTechnelogyAddDto cvTechnelogyDto) {
		AllDataResult allDataResult = new AllDataResult();
		CandidateCvTechnelogy candidateCvTechnelogy = new  CandidateCvTechnelogy();
		candidateCvTechnelogy.setCandidate(candidateDao.findById(cvTechnelogyDto.getCandidateId()).get());
		candidateCvTechnelogy.setUsedTechnology(cvTechnelogyDto.getUsedTechnology());
		this.candidateCvTechnelogyDao.save(candidateCvTechnelogy);
		allDataResult.addResult(new SuccessResult(Messages.candidateCvTechnelogy));
		return allDataResult.getSuccessResults();
	}

	@Override
	public List<Result> addCovverLetter(CandidateCvCovverLetterAddDto cvCovverLetterAddDto) {
		AllDataResult allDataResult = new AllDataResult();
		CandidateCvCovverLetter candidateCvCovverLetter = new CandidateCvCovverLetter();
		candidateCvCovverLetter.setCandidate(candidateDao.findById(cvCovverLetterAddDto.getCandidateId()).get());
		candidateCvCovverLetter.setComment(cvCovverLetterAddDto.getComment());
		this.candidateCvCovverLetterDao.save(candidateCvCovverLetter);
		allDataResult.addResult(new SuccessResult(Messages.candidateCvCovverLetter));
		return allDataResult.getSuccessResults();
	}
	
	



}
