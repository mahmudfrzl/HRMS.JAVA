package kodlamaio.hrms.entities.dtos;

import java.time.LocalDate;

import javax.persistence.Entity;

import kodlamaio.hrms.entities.concretes.City;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.JobPosition;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisementsDto {
	

	private String jobDescription;

	private int minSalary;
	private int maxSalary;
	private int numberOfPosition;
	private LocalDate applicationDate;
	private LocalDate createdAt ;
	private boolean enable;
	private int city;
	private int employer;
	private int jobPositions;
	
	
}
