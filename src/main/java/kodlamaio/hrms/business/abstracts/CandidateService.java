package kodlamaio.hrms.business.abstracts;




import java.util.List;


import kodlamaio.hrms.core.utilities.results.AllDataResult;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.dtos.CandidateCVTechnelogyAddDto;
import kodlamaio.hrms.entities.dtos.CandidateCvCovverLetterAddDto;
import kodlamaio.hrms.entities.dtos.CandidateCvExperienceAddDto;
import kodlamaio.hrms.entities.dtos.CandidateCvLanguageDto;
import kodlamaio.hrms.entities.dtos.CandidateCvLinkAddDto;
import kodlamaio.hrms.entities.dtos.CandidateCvSchoolAddDto;

public interface CandidateService {
	DataResult<List<Candidate>> getAll();	
	List<Result> add(Candidate candidate);
	DataResult<List<Candidate>> getById(int id);
	
	
	AllDataResult checkAllFields(Candidate candidate);
	public boolean checkEmail(String email);
	public boolean checkPassword(String password);
	public boolean checkIdentityCode(String identityNumber);
	public void emailVerification(int id);
	public void mernisVerification(String identityNumber);
	
	
	 List<Result> addSchool(CandidateCvSchoolAddDto cvSchoolAddDto);
	 List<Result> addExperience(CandidateCvExperienceAddDto cvExperienceAddDto);
	 List<Result> addLanguage(CandidateCvLanguageDto cvLanguageDto);
	 List<Result> addLink(CandidateCvLinkAddDto cvLinkAddDto);
	 List<Result> addTechnelogy(CandidateCVTechnelogyAddDto cvTechnelogyDto);
	 List<Result> addCovverLetter(CandidateCvCovverLetterAddDto cvCovverLetterAddDto);
	
	
}
