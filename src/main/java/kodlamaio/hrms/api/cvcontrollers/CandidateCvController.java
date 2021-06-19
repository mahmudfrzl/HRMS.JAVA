package kodlamaio.hrms.api.cvcontrollers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.core.utilities.cloudinaryAdapter.CloudinaryService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.dtos.CandidateCVTechnelogyAddDto;
import kodlamaio.hrms.entities.dtos.CandidateCvCovverLetterAddDto;
import kodlamaio.hrms.entities.dtos.CandidateCvExperienceAddDto;
import kodlamaio.hrms.entities.dtos.CandidateCvLanguageDto;
import kodlamaio.hrms.entities.dtos.CandidateCvLinkAddDto;
import kodlamaio.hrms.entities.dtos.CandidateCvSchoolAddDto;
import kodlamaio.hrms.entities.dtos.PhotoDto;

@RestController
@RequestMapping("/api/candidatecv")
@CrossOrigin
public class CandidateCvController {
	private CandidateService candidateService;
	private final CloudinaryService cloudinaryService;
	@Autowired
	
	public CandidateCvController(CandidateService candidateService,CloudinaryService cloudinaryService){
		this.candidateService = candidateService;
		this.cloudinaryService=cloudinaryService;
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
	@PostMapping("/upload")
	public ResponseEntity<?> upload(@RequestParam int candidateId,@RequestParam MultipartFile multipartFile) throws IOException {
		var result = cloudinaryService.upload(multipartFile);
		candidateService.addPhoto(new PhotoDto((String) result.getData().get("original_filename"),
				(String) result.getData().get("url"), (String) result.getData().get("public_id"), candidateId));

		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().body(result);
	}
}
