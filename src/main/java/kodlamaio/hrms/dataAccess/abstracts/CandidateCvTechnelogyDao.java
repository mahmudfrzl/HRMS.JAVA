package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.CandidateCvLanguage;
import kodlamaio.hrms.entities.concretes.CandidateCvTechnelogy;

public interface CandidateCvTechnelogyDao extends JpaRepository<CandidateCvTechnelogy, Integer>{
	@Query("From CandidateCvTechnelogy t inner join t.candidate c where c.id=:candidateId")
	List<CandidateCvTechnelogy> findByCandidateId(int candidateId);
}
