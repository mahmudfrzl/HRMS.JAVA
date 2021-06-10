package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.CandidateCvCovverLetter;
import kodlamaio.hrms.entities.concretes.CandidateCvLanguage;

public interface CandidateCvCovverLetterDao extends JpaRepository<CandidateCvCovverLetter, Integer>{
	@Query("From CandidateCvCovverLetter l inner join l.candidate c where c.id=:candidateId")
	List<CandidateCvCovverLetter> findByCandidateId(int candidateId);
}
