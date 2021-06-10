package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.School;
import kodlamaio.hrms.entities.dtos.SchoolAddDto;

public interface SchoolService {
	List<Result>  addSchool(SchoolAddDto addDto);
	DataResult<List<School>> getAll();
}
