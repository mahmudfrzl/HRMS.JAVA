package kodlamaio.hrms.business.concretes;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.AllDataResult;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CityDao;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hrms.dataAccess.abstracts.JobPositionDao;
import kodlamaio.hrms.entities.concretes.City;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.concretes.JobPosition;
import kodlamaio.hrms.entities.concretes.User;
import kodlamaio.hrms.entities.dtos.JobAdvertisementsDto;
@Service
public class JobAdvertisementManager implements JobAdvertisementService{
	private JobAdvertisementDao jobAdvertisementDao;
	private CityDao cityDao;
	private EmployerDao employerDao;
	private JobPositionDao jobPositionDao;
	
	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao, EmployerDao employerDao,CityDao cityDao,JobPositionDao jobPositionDao) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
		this.cityDao = cityDao;
		this.jobPositionDao= jobPositionDao;
		this.employerDao = employerDao;
		
	}
	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll());
	}
	@Override
	public JobAdvertisement findById(@RequestBody int id) {
		
		return this.jobAdvertisementDao.findById(id);
	}

	@Override
	public DataResult<List<JobAdvertisement>>findByAllEnable() {
		
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findByEnableTrue());

}
	@Override
	public DataResult<List<JobAdvertisement>>findByEnableTrueOrderByCreatedAtAsc() {
		
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findByEnableTrueOrderByCreatedAtAsc());
	}
	@Override
	public DataResult<List<JobAdvertisement>>findByEnableTrueOrderByApplicationDateDesc() {
		
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findByEnableTrueOrderByApplicationDateDesc());
	}
	@Override
	public DataResult<List<JobAdvertisement>> findByEmployerIdAndEnableTrue(@RequestBody int id){
		
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findByEmployerIdAndEnableTrue( id));
	}
	@Override
	public DataResult<List<JobAdvertisement>> findByEnableTrueAndEmployer_CompanyName(@RequestBody String companyName) {
		
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findByEnableTrueAndEmployer_CompanyName(companyName));
	}
	 
	@Override
	public List<Result>  add(JobAdvertisementsDto jobAdvertisementsDto) {
		AllDataResult allDataResult = new AllDataResult();
		allDataResult = checkJobAdvertisementDto(jobAdvertisementsDto);
		if(allDataResult.isSuccess()) {
			
		
		JobAdvertisement jobAdvertisement = new JobAdvertisement();
		
		Employer employer = new Employer(); 
		employer.setId(jobAdvertisementsDto.getEmployer());
		
		City city = new City(); 
		city.setId(jobAdvertisementsDto.getCity());
		
		JobPosition jobPosition = new JobPosition();
		jobPosition.setId(jobAdvertisementsDto.getJobPositions());
		
		jobAdvertisement.setEmployer(employer) ;
		jobAdvertisement.setCity(city);
		jobAdvertisement.setJobPositions(jobPosition);
		jobAdvertisement.setJobDescription(jobAdvertisementsDto.getJobDescription());
		jobAdvertisement.setMinSalary(jobAdvertisementsDto.getMinSalary());
		jobAdvertisement.setMaxSalary(jobAdvertisementsDto.getMaxSalary());
		jobAdvertisement.setNumberOfPosition(jobAdvertisementsDto.getNumberOfPosition());
		jobAdvertisement.setApplicationDate(jobAdvertisementsDto.getApplicationDate());
		jobAdvertisement.setCreatedAt(jobAdvertisementsDto.getCreatedAt());
		jobAdvertisement.setEnable(jobAdvertisementsDto.isEnable());
		this.jobAdvertisementDao.save(jobAdvertisement);
		allDataResult.addResult(new SuccessResult("Kayit islemi basarili"));
		return allDataResult.getSuccessResults();
		}
		return allDataResult.getErrorResults();
	}
	private AllDataResult checkJobAdvertisementDto(JobAdvertisementsDto jobAdvertisementsDto) {
		AllDataResult allDataResult = new AllDataResult();
		if(jobAdvertisementsDto.getNumberOfPosition()==0) {
			allDataResult.addResult(new ErrorResult("En az 1 kisi olmali"));
		}
		if(jobAdvertisementsDto.getJobDescription().length()<10) {
			allDataResult.addResult(new ErrorResult("En az 10 karakter olmali"));
		}
		if(cityDao.findById(jobAdvertisementsDto.getCity()).isEmpty()) {
			allDataResult.addResult(new ErrorResult("Sehir bulunamadi"));
		}
		return allDataResult;
	}
	
	



}
