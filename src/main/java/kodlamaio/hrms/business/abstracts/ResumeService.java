package kodlamaio.hrms.business.abstracts;

import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.dtos.ResumeDto;

public interface ResumeService {
	public DataResult<ResumeDto>  getAll( int candidateId);
}
