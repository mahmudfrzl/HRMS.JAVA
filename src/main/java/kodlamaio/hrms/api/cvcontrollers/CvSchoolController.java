package kodlamaio.hrms.api.cvcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CvSchoolService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CandidateCvSchool;
import kodlamaio.hrms.entities.dtos.CandidateCvSchoolAddDto;

@RestController
@RequestMapping("/api/cvschool")
public class CvSchoolController {
	private CvSchoolService cvSchoolService;
	@Autowired
	public CvSchoolController(CvSchoolService cvSchoolService) {
		super();
		this.cvSchoolService = cvSchoolService;
	}
	@GetMapping("/getall")
	public DataResult<List<CandidateCvSchool>> getAll() {
		return this.cvSchoolService.getAll();
	}
	@GetMapping("/findByCandidate_IdOrderByGradiationDateDesc")
	public DataResult<List<CandidateCvSchool>> findByCandidate_IdOrderByGradiationDateDesc(@RequestParam int id) {
		return this.cvSchoolService.findByCandidate_IdOrderByGradiationDateDesc(id);
	}
	@DeleteMapping("/delete")
	public Result delete(@RequestParam int id) {
		return this.cvSchoolService.delete(id);
	}

}
