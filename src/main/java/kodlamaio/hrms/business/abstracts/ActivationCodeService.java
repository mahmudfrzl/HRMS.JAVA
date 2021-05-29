package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;


public interface ActivationCodeService {
	public Result sendActivationCode(int id);
	
}
