package kodlamaio.hrms.business.concretes;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.business.constants.Messages;
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

import kodlamaio.hrms.entities.dtos.JobAdvertisementAddDto;
import kodlamaio.hrms.entities.dtos.JobAdvertisementListDto;
import net.bytebuddy.asm.Advice.This;
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
	public DataResult<List<JobAdvertisementListDto>> findByAllEnable() {
		
		return new SuccessDataResult<List<JobAdvertisementListDto>>(this.jobAdvertisementDao.findByEnableTrue(), Messages.DataListed);
}
	@Override
	public DataResult<List<JobAdvertisementListDto>> findByEnableTrueOrderByCreatedAtAsc() {
		
		return new SuccessDataResult<List<JobAdvertisementListDto>>(this.jobAdvertisementDao.findByEnableTrueOrderByCreatedAtAsc(), Messages.DataListed);
	}
	@Override
	public DataResult<List<JobAdvertisementListDto>> findByEnableTrueOrderByApplicationDateDesc() {
		
		return new SuccessDataResult<List<JobAdvertisementListDto>>(this.jobAdvertisementDao.findByEnableTrueOrderByApplicationDateDesc(), Messages.DataListed);
	}
	@Override
	public DataResult<List<JobAdvertisementListDto>>  findByEmployerIdAndEnableTrue(@RequestBody int id){
		
		return new SuccessDataResult<List<JobAdvertisementListDto>>(this.jobAdvertisementDao.findByEmployerIdAndEnableTrue(id), Messages.DataListed);
	}
	@Override
	public DataResult<List<JobAdvertisementListDto>>  findByEnableTrueAndEmployer_CompanyName(@RequestBody String companyName) {
		
		return new SuccessDataResult<List<JobAdvertisementListDto>>(this.jobAdvertisementDao.findByEnableTrueAndEmployer_CompanyName(companyName), Messages.DataListed);
	}
	 
	@Override
	public List<Result>  add(JobAdvertisementAddDto jobAdvertisementsDto) {
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

		jobAdvertisement.setNumberOfPosition(jobAdvertisementsDto.getNumberOfPosition());
		jobAdvertisement.setApplicationDate(jobAdvertisementsDto.getApplicationDate());
		jobAdvertisement.setCreatedAt(jobAdvertisementsDto.getCreatedAt());
		this.jobAdvertisementDao.save(jobAdvertisement);
		allDataResult.addResult(new SuccessResult(Messages.RegisterSuccess));
		return allDataResult.getSuccessResults();
		}
		return allDataResult.getErrorResults();
	}
	private AllDataResult checkJobAdvertisementDto(JobAdvertisementAddDto jobAdvertisementsDto) {
		AllDataResult allDataResult = new AllDataResult();
		if(jobAdvertisementsDto.getNumberOfPosition()==0) {
			allDataResult.addResult(new ErrorResult(Messages.NumberOfPositions));
		}
		if(jobAdvertisementsDto.getJobDescription().length()<5) {
			allDataResult.addResult(new ErrorResult(Messages.JobDescription));
		}
		if(cityDao.findById(jobAdvertisementsDto.getCity()).isEmpty()) {
			allDataResult.addResult(new ErrorResult(Messages.City));
		}
		if(jobAdvertisementsDto.getApplicationDate()==null) {
			allDataResult.addResult(new ErrorResult(Messages.applicationDate));
		}
		return allDataResult;
	}
	
	



}
