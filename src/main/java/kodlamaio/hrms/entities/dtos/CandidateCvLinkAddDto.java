package kodlamaio.hrms.entities.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@AllArgsConstructor
@NoArgsConstructor
public class CandidateCvLinkAddDto {
	private String githubLink;
	private String linkedinLink;
	private boolean isActive;
	private int candidateId;
}
