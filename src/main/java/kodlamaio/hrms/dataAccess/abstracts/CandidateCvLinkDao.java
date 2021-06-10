package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.CandidateCvLanguage;
import kodlamaio.hrms.entities.concretes.CandidateCvLink;

public interface CandidateCvLinkDao extends JpaRepository<CandidateCvLink, Integer>{
	@Query("From CandidateCvLink ccli inner join ccli.candidate c where c.id=:candidateId")
	List<CandidateCvLink> findByCandidateId(int candidateId);
}
