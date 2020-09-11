package com.lawyer.controllers;

import com.lawyer.helpers.Helper;
import com.lawyer.models.User;
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
public class ControllerUser {

  private static final String ENTITY_NAME = "user";

  @Autowired
  private Services<User> services;

  @Autowired
  private Helper<User> helper;

  /**
  * @return Response entity.
  */
  @RequestMapping(method = RequestMethod.GET, value = Paths.PATH_USERS)
  public ResponseEntity<ResponseBody> getAll() {
    helper.setEntityName(ENTITY_NAME);
    Response response = services.getAll();
    return ResponseEntity.status(response.getHttpStatus()).body(response.getBody());
  }

  /**
  * @param id id.
  * @return Response entity..
  */
  @RequestMapping(method = RequestMethod.GET, value = Paths.PATH_USERS_WITH_ID)
  public ResponseEntity<ResponseBody> getById(final @PathVariable Integer id) {
    helper.setEntityName(ENTITY_NAME);
    Response response = services.getById(id);
    return ResponseEntity.status(response.getHttpStatus()).body(response.getBody());
  }

  /**
  * @param user user.
  * @return Response entity.
  */
  @RequestMapping(method = RequestMethod.POST, value = Paths.PATH_USERS)
  public ResponseEntity<ResponseBody> add(final @RequestBody @Valid User user) {
    helper.setEntityName(ENTITY_NAME);
    Response response = services.add(user);
    return ResponseEntity.status(response.getHttpStatus()).body(response.getBody());
  }

  /**
  * @param user user.
  * @param id   id.
  * @return Response entity.
  */
  @RequestMapping(method = RequestMethod.PUT, value = Paths.PATH_USERS_WITH_ID)
  public ResponseEntity<ResponseBody> update(
      final @RequestBody @Valid User user, final @PathVariable Integer id) {
    helper.setEntityName(ENTITY_NAME);
    user.setId(id);
    Response response = services.update(user, id);
    return ResponseEntity.status(response.getHttpStatus()).body(response.getBody());
  }

  /**
  * @param id id.
  * @return Response entity.
  */
  @RequestMapping(method = RequestMethod.DELETE, value = Paths.PATH_USERS_WITH_ID)
  public ResponseEntity<ResponseBody> delete(final @PathVariable Integer id) {
    helper.setEntityName(ENTITY_NAME);
    Response response = services.delete(id);
    return ResponseEntity.status(response.getHttpStatus()).body(response.getBody());
  }
}
