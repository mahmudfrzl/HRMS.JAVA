package kodlamaio.hrms.api.cvcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.dtos.CandidateCVTechnelogyAddDto;
import kodlamaio.hrms.entities.dtos.CandidateCvCovverLetterAddDto;
import kodlamaio.hrms.entities.dtos.CandidateCvExperienceAddDto;
import kodlamaio.hrms.entities.dtos.CandidateCvLanguageDto;
import kodlamaio.hrms.entities.dtos.CandidateCvLinkAddDto;
import kodlamaio.hrms.entities.dtos.CandidateCvSchoolAddDto;

@RestController
@RequestMapping("/api/candidatecv")
public class CandidateCvController {
	private CandidateService candidateService;
	@Autowired
	
	public CandidateCvController(CandidateService candidateService){
		this.candidateService = candidateService;
	}
	@PostMapping("/addSchool")
	private List<Result> addSchool(@RequestBody CandidateCvSchoolAddDto cvSchoolAddDto){
		return this.candidateService.addSchool(cvSchoolAddDto);
	}
	@PostMapping("/addExperience")
	private List<Result> addExperience(@RequestBody CandidateCvExperienceAddDto cvExperienceAddDto){
		return this.candidateService.addExperience(cvExperienceAddDto);
	}
	@PostMapping("/addLanguage")
	public List<Result> addLanguage(@RequestBody CandidateCvLanguageDto cvLanguageDto) {
		return this.candidateService.addLanguage(cvLanguageDto);
	}
	@PostMapping("/addLink")
	public List<Result> addLink(@RequestBody CandidateCvLinkAddDto cvLinkAddDto) {
		return this.candidateService.addLink(cvLinkAddDto);
	}
	@PostMapping("/addTechnelogy")
	public List<Result> addTechnelogy(@RequestBody CandidateCVTechnelogyAddDto cvTechnelogyDto) {
		return this.candidateService.addTechnelogy(cvTechnelogyDto);
	}
	@PostMapping("/addCovverLetter")
	public List<Result> addCovverLetter(@RequestBody CandidateCvCovverLetterAddDto cvCovverLetterAddDto) {
		return this.candidateService.addCovverLetter(cvCovverLetterAddDto);
	}
}
