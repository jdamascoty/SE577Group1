package edu.drexel.TrainDemo.controllers;

import java.util.Collections;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.drexel.TrainDemo.models.Agency;
import edu.drexel.TrainDemo.repositories.AgencyRepository;

@RestController
public class UserController {

	@Autowired
	AgencyRepository agencyRepository;

	@GetMapping("/user")
	public Map<String, Object> user(@AuthenticationPrincipal OAuth2User principal) {
		return Collections.singletonMap("name", principal.getAttribute("login"));
	}

	@RequestMapping("/agencies")
	public String findAgencies() {
		String result = "<html>";

		for (Agency a : agencyRepository.findAll()) {
			result += "<div>" + a.toString() + "</div>";
		}

		return result + "</html>";
	}
}
