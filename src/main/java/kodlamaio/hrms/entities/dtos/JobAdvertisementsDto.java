package kodlamaio.hrms.entities.dtos;

import java.time.LocalDate;


import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisementsDto {
	@NotNull
	private int id;
	@NotNull
	@NotBlank
	private String jobDescription;
	@NotNull
	private int numberOfPosition;
	@NotNull
	private LocalDate applicationDate;
	@NotNull
	private LocalDate createdAt ;
	@NotNull
	private int city;
	@NotNull
	private int employer;
	@NotNull
	private int jobPositions;
	
	
}
