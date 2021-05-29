package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.base.Strings;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.core.utilities.adapters.EmailService;
import kodlamaio.hrms.core.utilities.results.AllDataResult;
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
	private EmailService emailService;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao,EmailService emailService) {
		super();
		this.employerDao = employerDao;
		this.emailService= emailService;
		
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(),"Is Veren Bilgileri Listelendi");
	}

	@Override
	public List<Result>  add(Employer employer) {
		AllDataResult allDataResult = new AllDataResult();
		allDataResult= checkAllFields(employer);
		
		if(allDataResult.isSuccess()) {
			emailVerification();
			allDataResult.addResult(new SuccessResult(Messages.emailAndHrmsPersonelVerification));
			employerDao.save(employer);
			allDataResult.addResult(new SuccessResult(Messages.LoginSuccessful));
			return allDataResult.getSuccessResults();
		}else {
			
			return allDataResult.getErrorResults();
		}
		
		
	}

	@Override
	public AllDataResult checkAllFields(Employer employer) {
		AllDataResult allDataResult = new AllDataResult();
		if
		( Strings.isNullOrEmpty(employer.getEmail())==true) {
			allDataResult.addResult(new ErrorResult(Messages.emailIsEmpty));
		}
		if
		( Strings.isNullOrEmpty(employer.getCompanyName())==true) {
			allDataResult.addResult(new ErrorResult(Messages.cNameIsEmpty));
		}
		if
		( Strings.isNullOrEmpty(employer.getPassword())==true) {
			allDataResult.addResult(new ErrorResult(Messages.passwordIsEmpty));
		}
		if
		( Strings.isNullOrEmpty(employer.getPhoneNumber())==true) {
			allDataResult.addResult(new ErrorResult(Messages.phoneNumberIsEmpty));
		}
		if
		( Strings.isNullOrEmpty(employer.getWebAdress())==true) {
			allDataResult.addResult(new ErrorResult(Messages.webSiteIsEmpty));
		}
		if(!checkEmail(employer.getEmail())) {
			allDataResult.addResult(new ErrorResult(Messages.ThisEmailAddressIsUsed));
		}
		if(!emailService.isOkay(employer.getEmail())) {
			allDataResult.addResult(new ErrorResult(Messages.wrogEmail));
		}

		



		return allDataResult;
	}

	@Override
	public boolean checkEmail(String email) {
		List<Employer> employers = getAll().getData();
		for(Employer employer:employers) {
			if(employer.getEmail().equals(email)) {
				return false;
			}		
		}
		return true;
		
	}

	@Override
	public void emailVerification() {
		
		
	}

}
