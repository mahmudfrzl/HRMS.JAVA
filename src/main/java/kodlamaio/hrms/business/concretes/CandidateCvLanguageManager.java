package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.LanguageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateCvLanguageDao;
import kodlamaio.hrms.entities.concretes.CandidateCvLanguage;

@Service
public class CandidateCvLanguageManager implements LanguageService{
private CandidateCvLanguageDao candidateCvLanguageDao;
@Autowired
	public CandidateCvLanguageManager(CandidateCvLanguageDao candidateCvLanguageDao) {
	super();
	this.candidateCvLanguageDao = candidateCvLanguageDao;
}
	@Override
	public DataResult<List<CandidateCvLanguage>> getAll() {
		
		return new SuccessDataResult<List<CandidateCvLanguage>>(this.candidateCvLanguageDao.findAll());
	}

}
