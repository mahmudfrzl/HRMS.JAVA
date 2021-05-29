package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.base.Strings;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;
@Service
public class EmployerManager implements EmployerService{
	private EmployerDao employerDao;
	@Autowired
	public EmployerManager(EmployerDao employerDao) {
		super();
		this.employerDao = employerDao;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(),"Is Veren Bilgileri Listelendi");
	}

	@Override
	public Result add(Employer employer) {
		checkAllFields(employer);
		checkEmail(employer.getEmail());
		return new SuccessResult(Messages.EmployerAdded);
	}

	@Override
	public Result checkAllFields(Employer employer) {
		if
		( Strings.isNullOrEmpty(employer.getEmail())			
	    ) {
			return new ErrorResult(Messages.emptyFields);
		}
		return new SuccessResult();
	}

	@Override
	public Result checkEmail(String email) {
		List<Employer> employers = getAll().getData();
		for(Employer employer:employers) {
			employer.getEmail().equals(email);
		}
		return null;
	}

}
