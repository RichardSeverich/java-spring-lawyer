package com.lawyer.controllers;

import com.lawyer.helpers.Helper;
import com.lawyer.models.Person;
import com.lawyer.repository.RepositoryPersons;
import com.lawyer.responses.Response;
import com.lawyer.responses.ResponseBody;
import com.lawyer.services.Services;
import com.lawyer.support.Paths;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * RestController.
 */
@RestController
public class ControllerPerson {

  private static final String ENTITY_NAME = "person";

  @Autowired
  private Services<Person> services;

  @Autowired
  private Helper<Person> helper;


  /**
  * @return Response entity.
  */
  @RequestMapping(method = RequestMethod.GET, value = Paths.PATH_PERSON)
  public ResponseEntity<ResponseBody> getAll() {
    helper.setEntityName(ENTITY_NAME);
    Response response = services.getAll();
    return ResponseEntity.status(response.getHttpStatus()).body(response.getBody());
  }

  /**
  * @param id id.
  * @return Response entity..
  */
  @RequestMapping(method = RequestMethod.GET, value = Paths.PATH_PERSON_WITH_ID)
  public ResponseEntity<ResponseBody> getById(final @PathVariable Integer id) {
    helper.setEntityName(ENTITY_NAME);
    Response response = services.getById(id);
    return ResponseEntity.status(response.getHttpStatus()).body(response.getBody());
  }

  /**
  * @param person person.
  * @return Response entity.
  */
  @RequestMapping(method = RequestMethod.POST, value = Paths.PATH_PERSON)
  public ResponseEntity<ResponseBody> add(final @RequestBody @Valid Person person) {
    helper.setEntityName(ENTITY_NAME);
    Response response = services.add(person);
    return ResponseEntity.status(response.getHttpStatus()).body(response.getBody());
  }

  /**
  * @param person person.
  * @param id   id.
  * @return Response entity.
  */
  @RequestMapping(method = RequestMethod.PUT, value = Paths.PATH_PERSON_WITH_ID)
  public ResponseEntity<ResponseBody> update(
      final @RequestBody @Valid Person person, final @PathVariable Integer id) {
    helper.setEntityName(ENTITY_NAME);
    person.setId(id);
    Response response = services.update(person, id);
    return ResponseEntity.status(response.getHttpStatus()).body(response.getBody());
  }

  /**
  * @param id id.
  * @return Response entity.
  */
  @RequestMapping(method = RequestMethod.DELETE, value = Paths.PATH_PERSON_WITH_ID)
  public ResponseEntity<ResponseBody> delete(final @PathVariable Integer id) {
    helper.setEntityName(ENTITY_NAME);
    Response response = services.delete(id);
    return ResponseEntity.status(response.getHttpStatus()).body(response.getBody());
  }
}
