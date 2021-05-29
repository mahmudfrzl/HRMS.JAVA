package kodlamaio.hrms.core.utilities.adapters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.fakeMernisService.FakeMernisManager;

@Service
public class MernisAdapter  implements MernisService{
	FakeMernisManager fakeMernisManager;
	@Autowired
	public MernisAdapter(FakeMernisManager fakeMernisManager) {
		super();
		this.fakeMernisManager = fakeMernisManager;
	}

	@Override
	public boolean isOkay(String identityNumber) {
		
		return this.fakeMernisManager.isOkay(identityNumber);
	}

}
