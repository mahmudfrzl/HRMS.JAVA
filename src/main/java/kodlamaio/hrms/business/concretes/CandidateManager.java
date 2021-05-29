package kodlamaio.hrms.business.concretes;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.base.Strings;

import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.business.abstracts.ActivationCodeService;
import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.core.utilities.adapters.EmailService;
import kodlamaio.hrms.core.utilities.adapters.MernisService;
import kodlamaio.hrms.core.utilities.results.AllDataResult;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.entities.concretes.Candidate;
@Service

public class CandidateManager implements CandidateService{
	
	private CandidateDao candidateDao;
	private EmailService emailService;
	private MernisService mernisService;
	private ActivationCodeService activationCodeService;

	@Autowired
	public CandidateManager(CandidateDao candidateDao,EmailService emailService,ActivationCodeService activationCodeService,MernisService mernisService) {
		super();
		this.candidateDao = candidateDao;
		this.emailService=emailService;
		this.activationCodeService = activationCodeService;
		this.mernisService=mernisService;

	}

	@Override
	public DataResult<List<Candidate>> getAll() {
		
		return new SuccessDataResult<List<Candidate>>( this.candidateDao.findAll(), Messages.DataListed   ) ;
	}

	@Override
	public List<Result> add(Candidate candidate) {
		AllDataResult allDataResult = new AllDataResult();
		allDataResult=checkAllFields(candidate);
		
		if(allDataResult.isSuccess()) {
			mernisService.isOkay(candidate.getIdentityNumber());
			allDataResult.addResult(new SuccessResult(Messages.mernisAuthentication));
			this.candidateDao.save(candidate);
			allDataResult.addResult(new SuccessResult(Messages.RegisterSuccess));
			activationCodeService.sendActivationCode(candidate.getId());
			allDataResult.addResult(new SuccessResult(Messages.generatedActivationCode));

			return allDataResult.getSuccessResults();
		}else {
			
			return allDataResult.getErrorResults();
			
		}
		
	}

	@Override
	public AllDataResult checkAllFields(Candidate candidate) {
		AllDataResult allDataResult = new AllDataResult();
		
//		if
//		
//		( Strings.isNullOrEmpty(candidate.getEmail()) ||
//		  Strings.isNullOrEmpty(candidate.getFirstName()) ||
//		  Strings.isNullOrEmpty(candidate.getLastName()) ||
//		  Strings.isNullOrEmpty(candidate.getPassword())||
//		  
//		  Strings.isNullOrEmpty(candidate.getIdentityNumber())||
//				candidate.getBirthDate() == null 			
//				
//	    ) {
//			return new ErrorResult(Messages.emptyFields);
//		}
		if(Strings.isNullOrEmpty(candidate.getEmail())==true){
			allDataResult.addResult(new ErrorResult(Messages.emailIsEmpty));
		} 
		if(Strings.isNullOrEmpty(candidate.getFirstName())==true){
			allDataResult.addResult(new ErrorResult(Messages.nameIsEmpty));
		}
		if(Strings.isNullOrEmpty(candidate.getLastName())==true){
			allDataResult.addResult(new ErrorResult(Messages.lastNameIsEmpty));
		}
		if(Strings.isNullOrEmpty(candidate.getIdentityNumber())==true){
			allDataResult.addResult(new ErrorResult(Messages.identityNumberIsEmpty));
		}
		if(Strings.isNullOrEmpty(candidate.getPassword())==true){
			allDataResult.addResult(new ErrorResult(Messages.passwordIsEmpty));
		}
		if(candidate.getBirthDate() == null) {
			allDataResult.addResult(new ErrorResult("Dogum tarihi bos"));
		}
		if(!emailService.isOkay(candidate.getEmail())) {
			allDataResult.addResult(new ErrorResult("Email hatali"));
		}
		if(!checkEmail(candidate.getEmail())) {
			allDataResult.addResult(new ErrorResult("Sistemde email kaydi mevcut"));
		}
		if(!checkPassword(candidate.getPassword())) {
			allDataResult.addResult(new ErrorResult("Sistemde sifre kaydi mevcut"));
		}
		if(!checkIdentityCode(candidate.getIdentityNumber())) {
			allDataResult.addResult(new ErrorResult("Sistemde tc no kaydi mevcut"));
		}
		

			
		return allDataResult;
	}

	@Override
	public boolean checkEmail(String email) {
		List<Candidate> candidates = getAll().getData();
		for(Candidate candidate : candidates) {
				if(candidate.getEmail().equals(email)) {
					return false;
				}				
		}
	
		return true;
	}

	@Override
	public boolean checkPassword(String password) {
		List<Candidate> candidates = getAll().getData();
		for(Candidate candidate : candidates) {
				if(candidate.getPassword().equals(password)) {
					return false;
				}				
		}
	
		return true;
	}

	@Override
	public boolean checkIdentityCode(String identityNumber) {
		List<Candidate> candidates = getAll().getData();
		for(Candidate candidate : candidates) {
				if(candidate.getIdentityNumber().equals(identityNumber)) {
					return false;
				}				
		}
	
		return true;
	}

	@Override
	public void emailVerification(int id) {
		this.activationCodeService.sendActivationCode(id);
		
	}

	@Override
	public void mernisVerification(String identityNumber) {
		mernisService.isOkay(identityNumber);
		
	}

}
