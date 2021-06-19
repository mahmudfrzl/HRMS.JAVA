package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.WorkingTypeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.WorkingTime;
import kodlamaio.hrms.entities.concretes.WorkingType;

@RestController 
@RequestMapping("/api/workingtype")
@CrossOrigin
public class WorkingTypeController {
private WorkingTypeService workingTypeService;
@Autowired
public WorkingTypeController(WorkingTypeService workingTypeService) {
	super();
	this.workingTypeService = workingTypeService;
}
@PostMapping("/add")
public Result add(@RequestBody WorkingType workingType) {
	return this.workingTypeService.add(workingType);
}
@GetMapping("/getall")
public DataResult<List<WorkingType>> getAll() {
	return this.workingTypeService.getAll();
}

}
