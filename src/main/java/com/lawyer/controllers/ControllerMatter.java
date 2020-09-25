package com.lawyer.controllers;

import com.lawyer.helpers.Helper;
import com.lawyer.models.Matter;
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
public class ControllerMatter {

  private static final String ENTITY_NAME = "matter";

  @Autowired
  private ServiceGet<Matter> serviceGet;

  @Autowired
  private ServiceGetById<Matter> serviceGetById;

  @Autowired
  private ServicePost<Matter> servicePost;

  @Autowired
  private ServicePut<Matter> servicePut;

  @Autowired
  private ServiceDelete<Matter> serviceDelete;

  @Autowired
  private Helper<Matter> helper;


  /**
  * @return Response entity.
  */
  @RequestMapping(method = RequestMethod.GET, value = Paths.PATH_MATTER)
  public ResponseEntity<ResponseBody> getAll() {
    helper.setEntityName(ENTITY_NAME);
    Response response = serviceGet.getResponse();
    return ResponseEntity.status(response.getHttpStatus()).body(response.getBody());
  }

  /**
  * @param id id.
  * @return Response entity..
  */
  @RequestMapping(method = RequestMethod.GET, value = Paths.PATH_MATTER_WITH_ID)
  public ResponseEntity<ResponseBody> getById(final @PathVariable Integer id) {
    helper.setEntityName(ENTITY_NAME);
    helper.setId(id);
    Response response = serviceGetById.getResponse();
    return ResponseEntity.status(response.getHttpStatus()).body(response.getBody());
  }

  /**
  * @param matter matter.
  * @return Response entity.
  */
  @RequestMapping(method = RequestMethod.POST, value = Paths.PATH_MATTER)
  public ResponseEntity<ResponseBody> add(final @RequestBody @Valid Matter matter) {
    helper.setEntityName(ENTITY_NAME);
    helper.setEntity(matter);
    Response response = servicePost.getResponse();
    return ResponseEntity.status(response.getHttpStatus()).body(response.getBody());
  }

  /**
  * @param matter matter.
  * @param id   id.
  * @return Response entity.
  */
  @RequestMapping(method = RequestMethod.PUT, value = Paths.PATH_MATTER_WITH_ID)
  public ResponseEntity<ResponseBody> update(
      final @RequestBody @Valid Matter matter, final @PathVariable Integer id) {
    helper.setEntityName(ENTITY_NAME);
    helper.setId(id);
    helper.setEntity(matter);
    matter.setId(id);
    Response response = servicePut.getResponse();
    return ResponseEntity.status(response.getHttpStatus()).body(response.getBody());
  }

  /**
  * @param id id.
  * @return Response entity.
  */
  @RequestMapping(method = RequestMethod.DELETE, value = Paths.PATH_MATTER_WITH_ID)
  public ResponseEntity<ResponseBody> delete(final @PathVariable Integer id) {
    helper.setEntityName(ENTITY_NAME);
    helper.setId(id);
    Response response = serviceDelete.getResponse();
    return ResponseEntity.status(response.getHttpStatus()).body(response.getBody());
  }
}
