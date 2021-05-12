package kodlamaio.hrms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import kodlamaio.hrms.api.controllers.JobPositionsController;
import kodlamaio.hrms.business.concretes.JobPositionManager;

@SpringBootApplication
public class HrmsApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(HrmsApplication.class, args);
	}

}
