package kodlamaio.hrms.dataAccess.abstracts;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;



import kodlamaio.hrms.entities.concretes.JobAdvertisement;


public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer>{
	List<JobAdvertisement> findByEnableTrue();
	List<JobAdvertisement> findByEnableTrueOrderByCreatedAtAsc();
	List<JobAdvertisement> findByEnableTrueOrderByApplicationDateDesc();
	List<JobAdvertisement> findByEnableTrueAndEmployer_CompanyName(String companyName);
	List<JobAdvertisement> findByEmployerIdAndEnableTrue(int id);
	JobAdvertisement findById(int id);
	
	
}
