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
@EqualsAndHashCode(callSuper = true)
@PrimaryKeyJoinColumn(name="id")
@Table(name="activation_code_employers")
@NoArgsConstructor
@AllArgsConstructor
public class ActivationCodeEmployer extends ActivationCode{
	@Column(name="employers_user_id")
	private int employerUserId;
}
