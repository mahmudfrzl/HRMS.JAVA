package kodlamaio.hrms.api.cvcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.TechnelogyService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.CandidateCvTechnelogy;
@RestController
@RequestMapping("/api/cvtechnelogy")
public class TechnelogyController {
	private TechnelogyService technelogyService;
	@Autowired
	public TechnelogyController(TechnelogyService technelogyService) {
		super();
		this.technelogyService = technelogyService;
	}
	@GetMapping("/getall")
	public DataResult<List<CandidateCvTechnelogy>> getAll() {
	return this.technelogyService.getAll();	
	}
}
