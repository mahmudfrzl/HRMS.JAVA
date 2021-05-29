package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ActivationCodeService;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.core.utilities.results.Result;

import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ActivationCodeDao;

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

}
