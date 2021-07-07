package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.models.Model;
import kodlamaio.hrms.business.abstracts.ActivationCodeService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.ActivationCode;

@RestController
@RequestMapping("/api/activationcode")

public class ActivationCodeController {
	private ActivationCodeService activationCodeService;
	@Autowired
	public ActivationCodeController(ActivationCodeService activationCodeService) {
		super();
		this.activationCodeService = activationCodeService;
	}
	@PostMapping("/sendcode")
	public Result sendActivationCode(@RequestParam int id) {
		return this.activationCodeService.sendActivationCode(id);
	}
	@PostMapping("/update/{verificationCode}/{id}")
	public Result setVerify(@RequestParam String activationCode, @RequestParam int id) {
		return activationCodeService.verify(activationCode, id);
	}
}


