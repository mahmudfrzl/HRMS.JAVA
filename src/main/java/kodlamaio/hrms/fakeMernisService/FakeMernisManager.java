package kodlamaio.hrms.fakeMernisService;

import org.springframework.stereotype.Component;

@Component
public class FakeMernisManager {
	public boolean isOkay(String identityNumber) {
		if(identityNumber.length()<11) {
			return false;
		}
		return true;
	}
}
