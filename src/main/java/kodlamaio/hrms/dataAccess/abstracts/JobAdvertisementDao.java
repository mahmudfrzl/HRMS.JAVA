package kodlamaio.hrms.dataAccess.abstracts;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementListDto;


public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer>{
	@Query("select new  kodlamaio.hrms.entities.dtos.JobAdvertisementListDto"
			+ "(j.id,e.companyName,j.jobPositions,j.numberOfPosition,j.applicationDate,j.createdAt)"
			+ "From JobAdvertisement j inner join j.employer e where j.enable=true")
	List<JobAdvertisementListDto> findByEnableTrue();

	List<JobAdvertisementListDto> findByEnableTrueOrderByCreatedAtAsc();

	List<JobAdvertisementListDto> findByEnableTrueOrderByApplicationDateDesc();

	List<JobAdvertisementListDto> findByEnableTrueAndEmployer_CompanyName(String companyName);
	
	@Modifying
	@Query("Update JobAdvertisement set enable=True where id=:id")
	   List<JobAdvertisementListDto> findByEmployerIdAndEnableTrue(@Param("id") int id);
	
	JobAdvertisement findById(int id);
	
	
}
