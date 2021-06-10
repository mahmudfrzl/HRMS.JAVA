package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.TechnelogyService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateCvTechnelogyDao;
import kodlamaio.hrms.entities.concretes.CandidateCvTechnelogy;

@Service

public class CandidateCvTechnelogyManager implements TechnelogyService{
	private CandidateCvTechnelogyDao  candidateCvTechnelogyDao;
	@Autowired
	public CandidateCvTechnelogyManager(CandidateCvTechnelogyDao candidateCvTechnelogyDao) {
		super();
		this.candidateCvTechnelogyDao = candidateCvTechnelogyDao;
	}
	@Override
	public DataResult<List<CandidateCvTechnelogy>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<CandidateCvTechnelogy>>(this.candidateCvTechnelogyDao.findAll());
	}
	
}
