package kodlamaio.hrms.api.controllers;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;

import kodlamaio.hrms.entities.concretes.JobAdvertisement;

import kodlamaio.hrms.entities.dtos.JobAdvertisementAddDto;
import kodlamaio.hrms.entities.dtos.JobAdvertisementListDto;
@RestController
@RequestMapping("/api/jobadvertisement")
@CrossOrigin
public class JobAdvertisementsController {
	private JobAdvertisementService jobAdvertisementService;
	@Autowired
	public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}
	@GetMapping("/getAll")
	public DataResult<List<JobAdvertisement>> getAll() {
		return this.jobAdvertisementService.getAll();
	}
	@GetMapping("/findById")
	public JobAdvertisement findById(@RequestParam int id) {
		return this.jobAdvertisementService.findById(id);
	}

	@GetMapping("/findByAllEnable")
	public DataResult<List<JobAdvertisementListDto>> findByAllEnable() {
		return this.jobAdvertisementService.findByAllEnable();
	}
	@GetMapping("/findByEnableTrueOrderByCreatedAtAsc")
	public DataResult<List<JobAdvertisementListDto>> findByEnableTrueOrderByCreatedAtAsc() {
			return this.jobAdvertisementService.findByEnableTrueOrderByCreatedAtAsc();
	}
	@GetMapping("/findByEnableTrueOrderByApplicationDateDesc")
	public DataResult<List<JobAdvertisementListDto>> findByEnableTrueOrderByApplicationDateDesc() {
			return this.jobAdvertisementService.findByEnableTrueOrderByApplicationDateDesc();
	}
	@Transactional
	@GetMapping("/findByEmployerIdAndEnableTrue")
	public DataResult<List<JobAdvertisementListDto>>  findByEmployerIdAndEnableTrue(@RequestParam int id){
			return this.jobAdvertisementService.findByEmployerIdAndEnableTrue( id);
	}
	@GetMapping("/findByEnableTrueAndCompanyName")
	public DataResult<List<JobAdvertisementListDto>>  findByEnableTrueAndEmployer_CompanyName(@RequestParam String companyName) {
			return this.jobAdvertisementService.findByEnableTrueAndEmployer_CompanyName(companyName);
	}
	@PostMapping("/add")
	public List<Result> add(@RequestBody  JobAdvertisementAddDto jobAdvertisementsDto) {
		return this.jobAdvertisementService.add(jobAdvertisementsDto);
	}
	@DeleteMapping("/delete")
	public Result delete(int id) {
		return this.jobAdvertisementService.delete(id);
	}
}
