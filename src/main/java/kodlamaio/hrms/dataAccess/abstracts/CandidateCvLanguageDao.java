package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.CandidateCvLanguage;


public interface CandidateCvLanguageDao extends JpaRepository<CandidateCvLanguage, Integer>{
	@Query("From CandidateCvLanguage ccl inner join ccl.candidate c where c.id=:candidateId")
	List<CandidateCvLanguage> findByCandidateId(int candidateId);
	
}
