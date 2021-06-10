package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.CandidateCvLanguage;
import kodlamaio.hrms.entities.concretes.CandidateCvSchool;

public interface CandidateCvSchoolDao extends JpaRepository<CandidateCvSchool, Integer>{
	@Query("From CandidateCvSchool s inner join s.candidate c where c.id=:candidateId")
	List<CandidateCvSchool> findByCandidateId(int candidateId);
}
