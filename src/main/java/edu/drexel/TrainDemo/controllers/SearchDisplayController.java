package edu.drexel.TrainDemo.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.drexel.TrainDemo.models.StopTimeResultSet;
import edu.drexel.TrainDemo.service.SearchService;

@Controller
public class SearchDisplayController {

	@Autowired
	private SearchService searchService;

	@RequestMapping("display")
	public ModelAndView search(HttpServletRequest request) {

		ModelAndView mvw = new ModelAndView();
		String origin = request.getParameter("origin");
		String destination = request.getParameter("destination");
//		searchService.translation(origin);
//		searchService.translation(destination);
		System.out.println(" " + searchService.translation(origin) + " " + searchService.translation(destination));
		List<StopTimeResultSet> resultSet = searchService.getStopsTimesBetweenTwo(searchService.translation(origin),
				searchService.translation(destination), null);
		System.out.println("ResultSet Size=" + resultSet.size());
		mvw.addObject("origin", request.getParameter("origin"));
		mvw.addObject("destination", request.getParameter("origin"));
		mvw.addObject("depart", request.getParameter("origin"));
		mvw.addObject("resultSet", resultSet);
		mvw.setViewName("Display.jsp");
		return mvw;
	}

}
