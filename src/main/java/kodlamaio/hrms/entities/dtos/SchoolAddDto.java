package kodlamaio.hrms.entities.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SchoolAddDto {
	
	private String name;
	private String schoolWebsite;
	private String schoolLogo;
	private int schoolType;
}
