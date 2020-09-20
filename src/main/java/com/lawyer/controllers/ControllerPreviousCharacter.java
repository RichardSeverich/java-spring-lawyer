package com.lawyer.controllers;

import com.lawyer.helpers.Helper;
import com.lawyer.models.PreviousCharacter;
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
public class ControllerPreviousCharacter {

  private static final String ENTITY_NAME = "previous_character";

  @Autowired
  private ServiceGet<PreviousCharacter> serviceGet;

  @Autowired
  private ServiceGetById<PreviousCharacter> serviceGetById;

  @Autowired
  private ServicePost<PreviousCharacter> servicePost;

  @Autowired
  private ServicePut<PreviousCharacter> servicePut;

  @Autowired
  private ServiceDelete<PreviousCharacter> serviceDelete;

  @Autowired
  private Helper<PreviousCharacter> helper;


  /**
  * @return Response entity.
  */
  @RequestMapping(method = RequestMethod.GET, value = Paths.PATH_PREVIOUS_CHARACTER)
  public ResponseEntity<ResponseBody> getAll() {
    helper.setEntityName(ENTITY_NAME);
    Response response = serviceGet.getResponse();
    return ResponseEntity.status(response.getHttpStatus()).body(response.getBody());
  }

  /**
  * @param id id.
  * @return Response entity..
  */
  @RequestMapping(method = RequestMethod.GET, value = Paths.PATH_PREVIOUS_CHARACTER_WITH_ID)
  public ResponseEntity<ResponseBody> getById(final @PathVariable Integer id) {
    helper.setEntityName(ENTITY_NAME);
    helper.setId(id);
    Response response = serviceGetById.getResponse();
    return ResponseEntity.status(response.getHttpStatus()).body(response.getBody());
  }

  /**
  * @param previousCharacter previousCharacter.
  * @return Response entity.
  */
  @RequestMapping(method = RequestMethod.POST, value = Paths.PATH_PREVIOUS_CHARACTER)
  public ResponseEntity<ResponseBody>
        add(final @RequestBody @Valid PreviousCharacter previousCharacter) {
    helper.setEntityName(ENTITY_NAME);
    helper.setEntity(previousCharacter);
    Response response = servicePost.getResponse();
    return ResponseEntity.status(response.getHttpStatus()).body(response.getBody());
  }

  /**
  * @param previousCharacter previousCharacter.
  * @param id   id.
  * @return Response entity.
  */
  @RequestMapping(method = RequestMethod.PUT, value = Paths.PATH_PREVIOUS_CHARACTER_WITH_ID)
  public ResponseEntity<ResponseBody> update(
        final @RequestBody @Valid PreviousCharacter previousCharacter,
        final @PathVariable Integer id) {
    helper.setEntityName(ENTITY_NAME);
    helper.setId(id);
    helper.setEntity(previousCharacter);
    previousCharacter.setId(id);
    Response response = servicePut.getResponse();
    return ResponseEntity.status(response.getHttpStatus()).body(response.getBody());
  }

  /**
  * @param id id.
  * @return Response entity.
  */
  @RequestMapping(method = RequestMethod.DELETE, value = Paths.PATH_PREVIOUS_CHARACTER_WITH_ID)
  public ResponseEntity<ResponseBody> delete(final @PathVariable Integer id) {
    helper.setEntityName(ENTITY_NAME);
    helper.setId(id);
    Response response = serviceDelete.getResponse();
    return ResponseEntity.status(response.getHttpStatus()).body(response.getBody());
  }
}
