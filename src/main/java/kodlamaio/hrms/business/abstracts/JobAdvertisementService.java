package kodlamaio.hrms.business.abstracts;


import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;

import kodlamaio.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementService {
	JobAdvertisement findById(int id);
	
	DataResult<List<JobAdvertisement>> getAll();
	DataResult<List<JobAdvertisement>> findByAllEnable();
	DataResult<List<JobAdvertisement>> findByEnableTrueOrderByCreatedAtAsc();
	DataResult<List<JobAdvertisement>> findByEnableTrueOrderByApplicationDateDesc();
	DataResult<List<JobAdvertisement>> findByEmployerIdAndEnableTrue(int id);
	DataResult<List<JobAdvertisement>>  findByEnableTrueAndEmployer_CompanyName(String companyName);
	
	
}
