package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.ActivationCodeService;
import kodlamaio.hrms.core.utilities.results.Result;

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
	public Result sendActivationCode(@RequestBody int id) {
		return this.activationCodeService.sendActivationCode(id);
	}
}
