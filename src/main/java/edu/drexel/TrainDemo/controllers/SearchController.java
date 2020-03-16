package edu.drexel.TrainDemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.drexel.TrainDemo.models.SearchModel;
import edu.drexel.TrainDemo.repositories.StopTimeRepository;
import edu.drexel.TrainDemo.service.OneWaySearchService;

@Controller

public class SearchController {
	@Autowired
	StopTimeRepository stoptimeRepository;

	@Autowired
	private OneWaySearchService searchService;

	@PostMapping("/search")
	public String getHomePage(Model model) {
		SearchModel searchModel = new SearchModel();
		String fromStop = null;
		String toStop = null;
		String date = null;
		boolean roundTrip;
		model.addAttribute("search", searchModel);
		return "index";
	}

	@RequestMapping("/booking")
	public String searchOneWayTrip(Model model) {
		SearchModel searchModel = new SearchModel();
		String fromStop = null;
		String toStop = null;
		String date = null;
		boolean roundTrip;
		model.addAttribute("booking", searchModel);
		searchService.getStopsTimesBetweenTwo(fromStop, toStop, date);
		System.out.println("hit");
		return "booking";
	}

}
