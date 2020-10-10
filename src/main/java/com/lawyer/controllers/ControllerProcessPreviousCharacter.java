package com.lawyer.controllers;

import com.lawyer.helpers.Helper;
import com.lawyer.models.PreviousCharacter;
import com.lawyer.responses.Response;
import com.lawyer.responses.ResponseBody;
import com.lawyer.services.ServicePreviousCharacter;
import com.lawyer.support.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * RestController.
 */
@RestController
public class ControllerProcessPreviousCharacter {

  @Autowired
  private ServicePreviousCharacter servicePreviousCharacter;

  @Autowired
  private Helper<PreviousCharacter> helper;

  /**
  * @param id id.
  * @return Response entity..
  */
  @RequestMapping(method = RequestMethod.GET, value = Paths.PROCESS_PREVIOUS_CHARACTER)
  public ResponseEntity<ResponseBody> getPreviousCharacter(final @PathVariable Integer id) {
    helper.setId(id);
    Response response = servicePreviousCharacter.getResponse();
    return ResponseEntity.status(response.getHttpStatus()).body(response.getBody());
  }
}
