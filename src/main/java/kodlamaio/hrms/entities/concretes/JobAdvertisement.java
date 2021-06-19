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
import lombok.NoArgsConstructor;
@Data
@Entity
@Table(name="job_advertisement")
@NoArgsConstructor
@AllArgsConstructor

public class JobAdvertisement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="job_description")
	private String jobDescription;
	@Column(name="min_salary")
	private int minSalary;
	@Column(name="max_salary")
	private int maxSalary;
	@Column(name="number_of_position")
	private int numberOfPosition;
	@Column(name="application_date")
	private LocalDate applicationDate;
	@Column(name="created_at")
	private LocalDate createdAt=LocalDate.now() ;
	@Column(name="enable")
	private boolean enable = true;
	
	
	@ManyToOne()
	@JoinColumn(name="city_id")
	private City city;
	
	@ManyToOne()
	@JoinColumn(name="employers_id")
	private Employer employer;
	
	@ManyToOne()
	@JoinColumn(name="job_positions_id")
	private JobPosition jobPositions;
	@ManyToOne()
	@JoinColumn(name="working_type_id")
	private WorkingType workingType;
	
	@ManyToOne()
	@JoinColumn(name="working_time_id")
	private WorkingTime workingTime;
}
