package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="candidate_cv_language")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class CandidateCvLanguage {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="language_level")
	private int languageLevel;
	@Column(name="name")
	private String name;
	
	@JsonIgnore
	@JoinColumn(name = "candidates_id")
	@ManyToOne
	private Candidate candidate;
	
	

	
}
