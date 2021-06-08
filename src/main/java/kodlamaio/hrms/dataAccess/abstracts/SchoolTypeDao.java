package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.SchoolType;

public interface SchoolTypeDao extends JpaRepository<SchoolType, Integer>{

}
