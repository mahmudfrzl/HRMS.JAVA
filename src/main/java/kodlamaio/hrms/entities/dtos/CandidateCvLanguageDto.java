package kodlamaio.hrms.entities.dtos;

import kodlamaio.hrms.entities.concretes.Candidate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidateCvLanguageDto {
	private int languageLevel;
	private String name;
	private int candidateId;
}
