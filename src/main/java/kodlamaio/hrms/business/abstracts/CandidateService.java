package kodlamaio.hrms.business.abstracts;




import java.util.List;


import kodlamaio.hrms.core.utilities.results.AllDataResult;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Candidate;

public interface CandidateService {
	DataResult<List<Candidate>> getAll();
	
	List<Result> add(Candidate candidate);
	AllDataResult checkAllFields(Candidate candidate);
	public boolean checkEmail(String email);
	public boolean checkPassword(String password);
	public boolean checkIdentityCode(String identityNumber);
	public void emailVerification(int id);
	public void mernisVerification(String identityNumber);
	
	
}
