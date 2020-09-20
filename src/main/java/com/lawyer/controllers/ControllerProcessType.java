package com.lawyer.controllers;

import com.lawyer.helpers.Helper;
import com.lawyer.models.ProcessType;
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
public class ControllerProcessType {

  private static final String ENTITY_NAME = "process_type";

  @Autowired
  private ServiceGet<ProcessType> serviceGet;

  @Autowired
  private ServiceGetById<ProcessType> serviceGetById;

  @Autowired
  private ServicePost<ProcessType> servicePost;

  @Autowired
  private ServicePut<ProcessType> servicePut;

  @Autowired
  private ServiceDelete<ProcessType> serviceDelete;

  @Autowired
  private Helper<ProcessType> helper;


  /**
  * @return Response entity.
  */
  @RequestMapping(method = RequestMethod.GET, value = Paths.PATH_PROCESS_TYPE)
  public ResponseEntity<ResponseBody> getAll() {
    helper.setEntityName(ENTITY_NAME);
    Response response = serviceGet.getResponse();
    return ResponseEntity.status(response.getHttpStatus()).body(response.getBody());
  }

  /**
  * @param id id.
  * @return Response entity..
  */
  @RequestMapping(method = RequestMethod.GET, value = Paths.PATH_PROCESS_TYPE_WITH_ID)
  public ResponseEntity<ResponseBody> getById(final @PathVariable Integer id) {
    helper.setEntityName(ENTITY_NAME);
    helper.setId(id);
    Response response = serviceGetById.getResponse();
    return ResponseEntity.status(response.getHttpStatus()).body(response.getBody());
  }

  /**
  * @param processType processType.
  * @return Response entity.
  */
  @RequestMapping(method = RequestMethod.POST, value = Paths.PATH_PROCESS_TYPE)
  public ResponseEntity<ResponseBody> add(final @RequestBody @Valid ProcessType processType) {
    helper.setEntityName(ENTITY_NAME);
    helper.setEntity(processType);
    Response response = servicePost.getResponse();
    return ResponseEntity.status(response.getHttpStatus()).body(response.getBody());
  }

  /**
  * @param processType processType.
  * @param id   id.
  * @return Response entity.
  */
  @RequestMapping(method = RequestMethod.PUT, value = Paths.PATH_PROCESS_TYPE_WITH_ID)
  public ResponseEntity<ResponseBody> update(
      final @RequestBody @Valid ProcessType processType, final @PathVariable Integer id) {
    helper.setEntityName(ENTITY_NAME);
    helper.setId(id);
    helper.setEntity(processType);
    processType.setId(id);
    Response response = servicePut.getResponse();
    return ResponseEntity.status(response.getHttpStatus()).body(response.getBody());
  }

  /**
  * @param id id.
  * @return Response entity.
  */
  @RequestMapping(method = RequestMethod.DELETE, value = Paths.PATH_PROCESS_TYPE_WITH_ID)
  public ResponseEntity<ResponseBody> delete(final @PathVariable Integer id) {
    helper.setEntityName(ENTITY_NAME);
    helper.setId(id);
    Response response = serviceDelete.getResponse();
    return ResponseEntity.status(response.getHttpStatus()).body(response.getBody());
  }
}
