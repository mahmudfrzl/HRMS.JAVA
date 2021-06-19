package kodlamaio.hrms.entities.dtos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisementAddDto {
	@NotNull
	private int id;
	@NotNull
	@NotBlank
	private String jobDescription;
	@NotNull
	private int numberOfPosition;
	@NotNull
	private LocalDate applicationDate;
	
	private LocalDate createdAt=LocalDate.now() ;
	@NotNull
	private int city;
	@NotNull
	private int employer;
	@NotNull
	private int jobPositions;	
	@NotNull
	private int minSalary;	
	@NotNull
	private int maxSalary;
	@NotNull
	private int workingType;
	@NotNull
	private int workingTime;
	
	
}
