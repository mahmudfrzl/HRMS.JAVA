package kodlamaio.hrms.api.cvcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.ExperienceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.CandidateCvExperience;

@RestController
@RequestMapping("/api/cvexperience")
public class ExperienceController {


private ExperienceService experienceService;
@Autowired
public ExperienceController(ExperienceService experienceService) {
	super();
	this.experienceService = experienceService;
	}
@GetMapping("/getAll")
public DataResult<List<CandidateCvExperience>> getAll() {
	return this.experienceService.getAll();
}



}
