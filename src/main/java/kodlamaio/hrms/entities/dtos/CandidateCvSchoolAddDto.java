package kodlamaio.hrms.entities.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidateCvSchoolAddDto {
	private int candidateId;
	private int schoolId;
	
	private String department;
	private LocalDate startDate;
	private LocalDate gradiationDate;
}
