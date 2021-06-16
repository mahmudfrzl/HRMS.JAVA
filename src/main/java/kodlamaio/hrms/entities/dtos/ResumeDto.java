package kodlamaio.hrms.entities.dtos;

import java.util.List;

import kodlamaio.hrms.entities.concretes.CandidateCvCovverLetter;
import kodlamaio.hrms.entities.concretes.CandidateCvExperience;
import kodlamaio.hrms.entities.concretes.CandidateCvLanguage;
import kodlamaio.hrms.entities.concretes.CandidateCvLink;
import kodlamaio.hrms.entities.concretes.CandidateCvSchool;
import kodlamaio.hrms.entities.concretes.CandidateCvTechnelogy;
import kodlamaio.hrms.entities.concretes.Photo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResumeDto {
	private int candidateId;
	private String email;
	private String firstName;
	private String lastName;
	private String candidatePhoto;
	private List<CandidateCvExperience> experiences;
	private List<CandidateCvLanguage> languages;
	private List<CandidateCvLink> links;
	private List<CandidateCvSchool> schools;
	private List<CandidateCvTechnelogy> technelogies;
	private List<CandidateCvCovverLetter> covverLetter;
	private List<Photo> photo;
}
