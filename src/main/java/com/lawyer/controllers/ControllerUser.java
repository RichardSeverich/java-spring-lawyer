package com.lawyer.controllers;

import com.lawyer.helpers.Helper;
import com.lawyer.models.User;
import com.lawyer.responses.Response;
import com.lawyer.responses.ResponseBody;
import com.lawyer.services.ServiceDelete;
import com.lawyer.services.ServiceGet;
import com.lawyer.services.ServiceGetById;
import com.lawyer.services.ServicePost;
import com.lawyer.services.ServicePut;
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
  private ServiceGet<User> serviceGet;

  @Autowired
  private ServiceGetById<User> serviceGetById;

  @Autowired
  private ServicePost<User> servicePost;

  @Autowired
  private ServicePut<User> servicePut;

  @Autowired
  private ServiceDelete<User> serviceDelete;

  @Autowired
  private Helper<User> helper;

  /**
  * @return Response entity.
  */
  @RequestMapping(method = RequestMethod.GET, value = Paths.PATH_USERS)
  public ResponseEntity<ResponseBody> getAll() {
    helper.setEntityName(ENTITY_NAME);
    Response response = serviceGet.getResponse();
    return ResponseEntity.status(response.getHttpStatus()).body(response.getBody());
  }

  /**
  * @param id id.
  * @return Response entity..
  */
  @RequestMapping(method = RequestMethod.GET, value = Paths.PATH_USERS_WITH_ID)
  public ResponseEntity<ResponseBody> getById(final @PathVariable Integer id) {
    helper.setEntityName(ENTITY_NAME);
    helper.setId(id);
    Response response = serviceGetById.getResponse();
    return ResponseEntity.status(response.getHttpStatus()).body(response.getBody());
  }

  /**
  * @param user user.
  * @return Response entity.
  */
  @RequestMapping(method = RequestMethod.POST, value = Paths.PATH_USERS)
  public ResponseEntity<ResponseBody> add(final @RequestBody @Valid User user) {
    helper.setEntityName(ENTITY_NAME);
    helper.setEntity(user);
    Response response = servicePost.getResponse();
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
    helper.setId(id);
    helper.setEntity(user);
    user.setId(id);
    Response response = servicePut.getResponse();
    return ResponseEntity.status(response.getHttpStatus()).body(response.getBody());
  }

  /**
  * @param id id.
  * @return Response entity.
  */
  @RequestMapping(method = RequestMethod.DELETE, value = Paths.PATH_USERS_WITH_ID)
  public ResponseEntity<ResponseBody> delete(final @PathVariable Integer id) {
    helper.setEntityName(ENTITY_NAME);
    helper.setId(id);
    Response response = serviceDelete.getResponse();
    return ResponseEntity.status(response.getHttpStatus()).body(response.getBody());
  }
}
