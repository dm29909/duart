package com.bezkoder.spring.restapi.service;

import java.util.ArrayList;
import java.util.List;

import com.bezkoder.spring.restapi.controller.TutorialController;
import org.springframework.stereotype.Service;

import com.bezkoder.spring.restapi.model.Tutorial;

@Service
public class TutorialService {

  static List<Tutorial> tutorials = new ArrayList<Tutorial>();
  static long id = 0;

  public List<Tutorial> findAll() {
    return tutorials;
  }

  public List<Tutorial> findByTitleContaining(String title) {
    return tutorials.stream().filter(tutorial -> tutorial.getTitle().contains(title)).toList();
  }

  public Tutorial findById(long id) {
    return tutorials.stream().filter(tutorial -> id == tutorial.getId()).findAny().orElse(null);
  }

  public Tutorial save(Tutorial tutorial) {
    // update Tutorial
    if (tutorial.getId() != 0) {
      long _id = tutorial.getId();

      for (int idx = 0; idx < tutorials.size(); idx++)
        if (_id == tutorials.get(idx).getId()) {
          tutorials.set(idx, tutorial);
          break;
        }

      return tutorial;
    }

    // create new Tutorial
    tutorial.setId(++id);
    tutorials.add(tutorial);
    return tutorial;
  }

  public List<Tutorial> deleteById(int id, List<Tutorial> list) {
      list.removeIf(tutorial -> tutorial.getId() == id);
    return list;
  }

}
