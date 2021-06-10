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

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="candidate_cv_school")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class CandidateCvSchool {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "school_start_date")
	private LocalDate startDate;
	@Column(name = "school_graduation_date")
	private LocalDate gradiationDate;
	@Column(name="school_department")
	private String schoolDepartment;
	@JsonIgnore
	@JoinColumn(name="candidates_id")
	@ManyToOne
	private Candidate candidate;
	
	
	@JoinColumn(name="school_id")
	@ManyToOne
	private School school;
	
	
}
