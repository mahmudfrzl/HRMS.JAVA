package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.CandidateCvTechnelogy;
import kodlamaio.hrms.entities.concretes.Photo;

public interface PhotoDao extends JpaRepository<Photo, Integer>{
	@Query("From Photo p inner join p.candidate c where c.id=:candidateId")
	List<Photo> findByCandidateId(int candidateId);
}
