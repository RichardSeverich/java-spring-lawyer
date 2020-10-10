package com.lawyer.controllers;

import com.lawyer.helpers.Helper;
import com.lawyer.models.ProcessType;
import com.lawyer.responses.Response;
import com.lawyer.responses.ResponseBody;
import com.lawyer.services.ServiceProcessType;
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
public class ControllerMatterProcessType {

  @Autowired
  private ServiceProcessType serviceProcessType;

  @Autowired
  private Helper<ProcessType> helper;

  /**
  * @param id id.
  * @return Response entity..
  */
  @RequestMapping(method = RequestMethod.GET, value = Paths.MATTER_PROCESS_TYPE)
  public ResponseEntity<ResponseBody> getProcessType(final @PathVariable Integer id) {
    helper.setId(id);
    Response response = serviceProcessType.getResponse();
    return ResponseEntity.status(response.getHttpStatus()).body(response.getBody());
  }
}
