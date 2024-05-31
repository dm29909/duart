package com.bezkoder.spring.restapi;

import com.bezkoder.spring.restapi.controller.TutorialController;
import com.bezkoder.spring.restapi.model.Tutorial;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class SpringBoot3RestApiExampleApplicationTests {

	@Test
	void getAllTutorials() {

		ResponseEntity<List<Tutorial>> response = new TutorialController().getAllTutorials(null);
		System.out.println(response);
	}
	@Test
	void createTutroial() {
		Tutorial tutorial = new Tutorial(8,"Duart", "Dec1", true);
		System.out.println(tutorial.toString());
	}
	@Test
	void getById() {
		ResponseEntity<Tutorial> response = new TutorialController().getTutorialById(7);
		System.out.println(response);
	}
	@Test
	void deleteById() {
		ResponseEntity<List<Tutorial>> response = new TutorialController().deleteTutorial(4, new Tutorial().listOfTutorials() );
		System.out.println(response);
	}
	@Test
	void updateById() {
		ResponseEntity<List<Tutorial>> response = new TutorialController().updateTutorial(7, new Tutorial(0, "hello7", "world7", true));
		System.out.println(response);
	}

}
