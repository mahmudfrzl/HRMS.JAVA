package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.WorkingTimeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.WorkingTime;
@RestController
@RequestMapping("/api/workingtime")
@CrossOrigin
public class WorkingTimeController {
private WorkingTimeService workingTimeService;
@Autowired
public WorkingTimeController(WorkingTimeService workingTimeService) {
	super();
	this.workingTimeService = workingTimeService;
}
@PostMapping("add")
public Result add(@RequestBody WorkingTime workingTime) {
	return this.workingTimeService.add(workingTime);
}
@GetMapping("/getall")
public DataResult<List<WorkingTime>> getAll() {
	return this.workingTimeService.getAll();
}
}
