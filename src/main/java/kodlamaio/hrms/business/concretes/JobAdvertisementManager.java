package kodlamaio.hrms.business.concretes;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;

import kodlamaio.hrms.core.utilities.results.DataResult;

import kodlamaio.hrms.core.utilities.results.SuccessDataResult;

import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
@Service
public class JobAdvertisementManager implements JobAdvertisementService{
	private JobAdvertisementDao jobAdvertisementDao;
	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
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




}
