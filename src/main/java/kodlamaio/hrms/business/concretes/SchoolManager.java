package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.SchoolService;
import kodlamaio.hrms.core.utilities.results.AllDataResult;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.SchoolDao;
import kodlamaio.hrms.dataAccess.abstracts.SchoolTypeDao;
import kodlamaio.hrms.entities.concretes.School;
import kodlamaio.hrms.entities.dtos.SchoolAddDto;

@Service
public class SchoolManager implements SchoolService{
private SchoolDao schoolDao;
private SchoolTypeDao schoolTypeDao;
@Autowired
public SchoolManager(SchoolDao schoolDao,SchoolTypeDao schoolTypeDao ) {
	super();
	this.schoolDao = schoolDao;
	this.schoolTypeDao = schoolTypeDao;
}

@Override
public List<Result> addSchool(SchoolAddDto addDto) {
	AllDataResult allDataResult = new AllDataResult();
	School school = new School();
	school.setName(addDto.getName());
	school.setSchoolLogo(addDto.getSchoolLogo());
	
	
	school.setSchoolType(schoolTypeDao.findById(addDto.getSchoolType()).get());
	school.setSchoolWebsite(addDto.getSchoolWebsite());
	this.schoolDao.save(school);
	allDataResult.addResult(new SuccessResult("Kayit basarili"));
	return allDataResult.getSuccessResults();
}

@Override
public DataResult<List<School>> getAll() {
	
	return new SuccessDataResult<List<School>>(this.schoolDao.findAll());
}
}
