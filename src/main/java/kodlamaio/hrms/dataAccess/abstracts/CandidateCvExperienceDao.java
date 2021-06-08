package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.CandidateCvExperience;

public interface CandidateCvExperienceDao extends JpaRepository<CandidateCvExperience, Integer>{

}
