package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.CandidateCvExperience;


public interface CandidateCvExperienceDao extends JpaRepository<CandidateCvExperience, Integer>{
	@Query("From CandidateCvExperience cce inner join cce.candidate c where c.id=:candidateId")
	List<CandidateCvExperience> findByCandidateId(int candidateId);
	List<CandidateCvExperience> findByCandidate_IdOrderByStartDateDesc(int id);
}
