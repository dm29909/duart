package com.bezkoder.spring.restapi.controller;

import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bezkoder.spring.restapi.model.Tutorial;
import com.bezkoder.spring.restapi.service.TutorialService;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class TutorialController {
    @Autowired
    TutorialService tutorialService = new TutorialService();

    @GetMapping("/tutorials")
    public ResponseEntity<List<Tutorial>> getAllTutorials(@RequestParam(required = false) String title) {
        return ResponseEntity.ok(new Tutorial().listOfTutorials());
    }

    @GetMapping("/tutorials/{id}")
    public ResponseEntity<Tutorial> getTutorialById(@PathVariable("id") int id) {
        Tutorial tutorial = new Tutorial();
        for (Tutorial tutorials : new Tutorial().listOfTutorials()) {
            if (tutorials.getId() == id) {
                tutorial = tutorials;
            }
        }
        if (tutorial != null) {
            return new ResponseEntity<>(tutorial, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/tutorials")
    public ResponseEntity<Tutorial> createTutorial(@RequestBody Tutorial tutorial) {
        try {
            Tutorial _tutorial = tutorialService
                    .save(new Tutorial(7, tutorial.getTitle(), tutorial.getDescription(), false));
            return new ResponseEntity<>(_tutorial, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/tutorials/{id}")
    public ResponseEntity<List<Tutorial>> updateTutorial(@PathVariable("id") int id,  Tutorial tutorial) {
      List<Tutorial> list = new Tutorial().listOfTutorials();
      for(Tutorial tutorials : list){
        if(tutorials.getId()==id){
          tutorials.setTitle(tutorial.getTitle());
          tutorials.setDescription(tutorial.getDescription());
          tutorials.setPublished(tutorial.isPublished());
        }
      }
      return ResponseEntity.ok(list);
    }

    @DeleteMapping("/tutorials/{id}")
    public ResponseEntity<List<Tutorial>> deleteTutorial(@PathVariable("id") int id, List<Tutorial> tutorials) {
        return ResponseEntity.ok(tutorialService.deleteById(id, tutorials));
    }
}
