package kodlamaio.hrms.entities.dtos;

import java.time.LocalDate;

import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.JobPosition;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidateCvExperienceAddDto {
	
	private String workPlaceName;
	private LocalDate startDate;
	private LocalDate quitDate;
	private int candidateId;
	private int jobPositionId;
}
