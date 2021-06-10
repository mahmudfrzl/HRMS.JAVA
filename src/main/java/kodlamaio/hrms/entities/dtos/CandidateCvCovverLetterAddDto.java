package kodlamaio.hrms.entities.dtos;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@AllArgsConstructor
@NoArgsConstructor
public class CandidateCvCovverLetterAddDto {
	private String comment;
	private int candidateId;
}
