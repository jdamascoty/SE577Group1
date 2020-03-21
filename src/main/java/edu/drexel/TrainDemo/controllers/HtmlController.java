package edu.drexel.TrainDemo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.drexel.TrainDemo.models.Stop;
import edu.drexel.TrainDemo.repositories.StopRepository;

@Controller
public class HtmlController {

	@Autowired
	private StopRepository stopRepository;
	
	@RequestMapping("/")
	public ModelAndView homepage() {
		
		List<Stop> listOfStops = stopRepository.findAll();
		List<String> listStopNames = new ArrayList<>();
		listStopNames.add("");
		for(int i = 0; i < listOfStops.size(); i++) {
			listStopNames.add(listOfStops.get(i).getName());
		}

		ModelAndView mvw = new ModelAndView();
		mvw.addObject("listStopNames", listStopNames);
		mvw.setViewName("Homepage.jsp");
		return mvw;
	}
}
