package kodlamaio.hrms.core.utilities.adapters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.fakeEmailService.FakeEmailManager;
@Service
public class EmailAdapter implements EmailService{
	@Autowired
	FakeEmailManager fakeEmailManager;
	public EmailAdapter(FakeEmailManager fakeEmailManager) {
		super();
		this.fakeEmailManager = fakeEmailManager;
	}
	@Override
	public boolean isOkay(String email) {
		
		return this.fakeEmailManager.isOkay(email);
	}



}
