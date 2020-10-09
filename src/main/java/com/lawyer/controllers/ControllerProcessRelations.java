package com.lawyer.controllers;

import com.lawyer.helpers.Helper;
import com.lawyer.models.Person;
import com.lawyer.responses.Response;
import com.lawyer.responses.ResponseBody;
import com.lawyer.services.ServicePersonsDefendant;
import com.lawyer.services.ServicePersonsDemandant;
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
public class ControllerProcessRelations {

  @Autowired
  private ServicePersonsDemandant servicePersonsDemandant;

  @Autowired
  private ServicePersonsDefendant servicePersonsDefendant;

  @Autowired
  private Helper<Person> helper;

  /**
  * @param id id.
  * @return Response entity..
  */
  @RequestMapping(method = RequestMethod.GET, value = Paths.PROCESS_PERSON_DEFENDANT)
  public ResponseEntity<ResponseBody> getDefendants(final @PathVariable Integer id) {
    helper.setId(id);
    Response response = servicePersonsDefendant.getResponse();
    return ResponseEntity.status(response.getHttpStatus()).body(response.getBody());
  }

  /**
  * @param id id.
  * @return Response entity..
  */
  @RequestMapping(method = RequestMethod.GET, value = Paths.PROCESS_PERSON_DEMANDANT)
  public ResponseEntity<ResponseBody> getDemandants(final @PathVariable Integer id) {
    helper.setId(id);
    Response response = servicePersonsDemandant.getResponse();
    return ResponseEntity.status(response.getHttpStatus()).body(response.getBody());
  }
}
