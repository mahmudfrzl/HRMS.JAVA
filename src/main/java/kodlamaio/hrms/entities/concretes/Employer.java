package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
@Data
@Entity
@Table(name="employers")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@PrimaryKeyJoinColumn(name = "employers_id")
public class Employer extends User{
	
	

	@Column(name="company_name")
	private String companyName;
	@Column(name="web_address")
	private String webAdress;
	@Column(name="phone_number")
	private String phoneNumber;
	@Column(name="is_activated")
	private boolean isActivated;

}
