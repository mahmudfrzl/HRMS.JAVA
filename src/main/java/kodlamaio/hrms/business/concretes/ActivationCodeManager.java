package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.swagger.models.Model;
import kodlamaio.hrms.business.abstracts.ActivationCodeService;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.core.utilities.GenerateRandomCode;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ActivationCodeDao;
import kodlamaio.hrms.entities.concretes.ActivationCode;

@Service
public class ActivationCodeManager implements ActivationCodeService{
	private ActivationCodeDao activationCodeDao;
	@Autowired
	public ActivationCodeManager(ActivationCodeDao activationCodeDao) {
		super();
		this.activationCodeDao = activationCodeDao;
	}
	@Override
	public Result sendActivationCode(int id) {
		this.activationCodeDao.getOne(id);
		return new SuccessResult(Messages.sendActivationCode);
	}
	@Override
	public void activationCode(ActivationCode code, int id) {
		ActivationCode code_ = code;
		code.setActivationCode(null);
		code.setConfirmed(false);
		
		if(code.isConfirmed() == false) {
			GenerateRandomCode generator = new GenerateRandomCode();
			String code_create = generator.create();
			code.setActivationCode(code_create);
			code.setId(id);
			activationCodeDao.save(code);
		}
		return ;
		
	}
	@Override
	public Result verify(String activationCode, int id) {
		ActivationCode ref = activationCodeDao.findById(id).stream().findFirst().get();
		if(ref.getActivationCode().equals(activationCode) && ref.isConfirmed() != true) {
			ref.setConfirmed(true);
			return new SuccessDataResult<ActivationCode>(this.activationCodeDao.save(ref), "Success");
		}
		else if(ref.isConfirmed() == true) {
			return new ErrorDataResult<ActivationCode>(null, "Already Verified Account");
		}
		return new ErrorDataResult<ActivationCode>(null,"Verification Code Invalid");
	}


}
