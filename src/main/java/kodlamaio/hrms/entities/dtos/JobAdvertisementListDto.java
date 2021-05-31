package kodlamaio.hrms.entities.dtos;

import java.time.LocalDate;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data

@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisementListDto {
	
	private int id;	
	private String jobDescription;
	private int minSalary;
	private int maxSalary;
	private int numberOfPosition;
	private LocalDate applicationDate;
	private LocalDate createdAt ;
	private boolean enable;
	private int city;
	private int employersId;
	private int jobPosition;
	private String cityName;
	private String jobPositionName;
	private String companyName;
	private String webAdress;
	private String phoneNumber;
	private boolean isActivated;
	private String jobAdvertisementTitle;
}
