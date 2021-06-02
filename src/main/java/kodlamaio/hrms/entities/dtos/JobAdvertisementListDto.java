package kodlamaio.hrms.entities.dtos;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

import kodlamaio.hrms.entities.concretes.JobPosition;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data

@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisementListDto {
	@NotNull
	private int id;
	@NotNull
	@NotBlank
	private String companyName;	
	@NotNull
	@NotBlank
	private JobPosition jobPositions;
	@NotNull
	private int numberOfPosition;
	@NotNull	
	private LocalDate applicationDate;
	@NotNull
	private LocalDate createdAt ;
}
