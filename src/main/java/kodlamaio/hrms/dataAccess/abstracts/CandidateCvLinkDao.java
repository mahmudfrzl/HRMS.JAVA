package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.CandidateCvLink;

public interface CandidateCvLinkDao extends JpaRepository<CandidateCvLink, Integer>{

}
