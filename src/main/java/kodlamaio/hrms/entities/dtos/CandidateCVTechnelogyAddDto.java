package kodlamaio.hrms.entities.dtos;

import kodlamaio.hrms.entities.concretes.Candidate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CandidateCVTechnelogyAddDto {
	private String usedTechnology;
	private int candidateId;
}
