package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="links")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode

public class CandidateCvLink {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="github_link")
	private String githubLink;
	@Column(name="linkedin_link")
	private String linkedinLink;
	@Column(name="is_active")
	private boolean isActive;
	
	
	@Column(name="is_deleted")
	private boolean isDeleted;
	@JoinColumn(name = "candidates_id")
	@ManyToOne
	private Candidate candidate;
}
