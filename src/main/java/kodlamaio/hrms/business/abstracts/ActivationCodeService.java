package kodlamaio.hrms.business.abstracts;

import io.swagger.models.Model;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.ActivationCode;


public interface ActivationCodeService {
	public Result sendActivationCode(int id);
	public void activationCode(ActivationCode code, int id);
	public Result verify(String activationCode,int id);
}
