package edu.drexel.TrainDemo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.drexel.TrainDemo.service.OneWaySearchService;
import edu.drexel.TrainDemo.service.TwoWaySearchService;

@SpringBootTest
class TrainDemoApplicationTests {

	@Autowired
	OneWaySearchService searchService;

	@Autowired
	TwoWaySearchService altsearchService;

	@Test
	void contextLoads() {
	}

	@Test
	public void testStoptimes() {
		altsearchService.searchRoundTrip("LTM", "PLS", "12-03-2020", "13-03-2020");
	}

}
