package kodlamaio.hrms.business.abstracts;


import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementAddDto;
import kodlamaio.hrms.entities.dtos.JobAdvertisementListDto;

public interface JobAdvertisementService {
	JobAdvertisement findById(int id);
	List<Result>  add(JobAdvertisementAddDto jobAdvertisementsDto);
	DataResult<List<JobAdvertisement>> getAll();
	DataResult<List<JobAdvertisementListDto>>  findByAllEnable();
	DataResult<List<JobAdvertisementListDto>>  findByEnableTrueOrderByCreatedAtAsc();
	DataResult<List<JobAdvertisementListDto>> findByEnableTrueOrderByApplicationDateDesc();
	DataResult<List<JobAdvertisementListDto>>  findByEmployerIdAndEnableTrue(int id);
	DataResult<List<JobAdvertisementListDto>>   findByEnableTrueAndEmployer_CompanyName(String companyName);
	
	
	
	
}
