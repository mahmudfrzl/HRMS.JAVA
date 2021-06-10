package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="candidate_cv_experience")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode

public class CandidateCvExperience {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@NotNull
	@NotBlank
	@Column(name="work_place_name")
	private String workPlaceName;
	@PastOrPresent
	@NotNull
	@Column(name="start_date")
	private LocalDate startDate;
	@PastOrPresent
	
	@Column(name="quit_date")
	private LocalDate quitDate;
	
	@JsonIgnore
	@JoinColumn(name="candidates_id")
	@ManyToOne
	private Candidate candidate;
	@NotNull
	@NotBlank
	@JoinColumn(name="job_positions_id")
	@ManyToOne
	private JobPosition jobPositions;
}
