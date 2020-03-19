package edu.drexel.TrainDemo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.drexel.TrainDemo.service.SearchService;

@SpringBootTest
class TrainDemoApplicationTests {

	@Autowired
	private SearchService searchService;

	@Test
	void contextLoads() {
	}

	@Test
	void checkForOutput() {
		searchService.getStopsTimesBetweenTwo("NYP", "NOL", null);
	}

}
