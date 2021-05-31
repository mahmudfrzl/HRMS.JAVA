package kodlamaio.hrms.dataAccess.abstracts;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementsDto;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer>{
	List<JobAdvertisement> findByEnableTrue();
	List<JobAdvertisement> findByEnableTrueOrderByCreatedAtAsc();
	List<JobAdvertisement> findByEnableTrueOrderByApplicationDateDesc();
	List<JobAdvertisement> findByEnableTrueAndEmployer_CompanyName(String companyName);
	List<JobAdvertisement> findByEmployerIdAndEnableTrue(int id);
	JobAdvertisement findById(int id);
	
	
}
