package kodlamaio.hrms.dataAccess.abstracts;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementListDto;


public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer>{
	@Query("select new  kodlamaio.hrms.entities.dtos.JobAdvertisementListDto"
			+ "(j.id,e.companyName,j.jobPositions,j.numberOfPosition,j.applicationDate,j.createdAt)"
			+ "From JobAdvertisement j inner join j.employer e where j.enable=true")
	List<JobAdvertisementListDto> findByEnableTrue();
	@Query("select new  kodlamaio.hrms.entities.dtos.JobAdvertisementListDto"
			+ "(j.id,e.companyName,j.jobPositions,j.numberOfPosition,j.applicationDate,j.createdAt)"
			+ "From JobAdvertisement j inner join j.employer e where j.enable=true")
	List<JobAdvertisementListDto> findByEnableTrueOrderByCreatedAtAsc();
	@Query("select new  kodlamaio.hrms.entities.dtos.JobAdvertisementListDto"
			+ "(j.id,e.companyName,j.jobPositions,j.numberOfPosition,j.applicationDate,j.createdAt)"
			+ "From JobAdvertisement j inner join j.employer e where j.enable=true")
	List<JobAdvertisementListDto> findByEnableTrueOrderByApplicationDateDesc();
	@Query("select new  kodlamaio.hrms.entities.dtos.JobAdvertisementListDto"
			+ "(j.id,e.companyName,j.jobPositions,j.numberOfPosition,j.applicationDate,j.createdAt)"
			+ "From JobAdvertisement j inner join j.employer e where j.enable=true")
	List<JobAdvertisementListDto> findByEnableTrueAndEmployer_CompanyName(String companyName);
	@Query("select new  kodlamaio.hrms.entities.dtos.JobAdvertisementListDto"
			+ "(j.id,e.companyName,j.jobPositions,j.numberOfPosition,j.applicationDate,j.createdAt)"
			+ "From JobAdvertisement j inner join j.employer e where j.enable=true")
	List<JobAdvertisementListDto> findByEmployerIdAndEnableTrue(int id);
	JobAdvertisement findById(int id);
	
	
}
