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
@Table(name="activation_code_candidates")
@EqualsAndHashCode(callSuper = true)
@PrimaryKeyJoinColumn(name="id")
@NoArgsConstructor
@AllArgsConstructor
public class ActivationCodeCandidate extends ActivationCode{
	@Column(name="candidate_user_id")
	private int candidateUserId;
}
