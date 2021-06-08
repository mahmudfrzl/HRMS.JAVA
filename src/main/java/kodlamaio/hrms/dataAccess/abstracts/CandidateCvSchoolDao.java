package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.CandidateCvSchool;

public interface CandidateCvSchoolDao extends JpaRepository<CandidateCvSchool, Integer>{

}
