package com.lawyer.controllers;

import com.lawyer.helpers.Helper;
import com.lawyer.models.UserAuth;
import com.lawyer.responses.Response;
import com.lawyer.responses.ResponseBody;
import com.lawyer.services.ServiceLogin;
import com.lawyer.support.Paths;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerLogin {

  private static final String ENTITY_NAME = "userAuth";

  @Autowired
  private ServiceLogin serviceLogin;

  @Autowired
  private Helper<UserAuth> helper;

  /**
  * @param userAuth userAuth.
  * @return Response Entity.
  */
  @RequestMapping(method = RequestMethod.POST, value = Paths.PATH_LOGIN)
  public ResponseEntity<ResponseBody> login(final @RequestBody @Valid UserAuth userAuth) {
    helper.setEntityName(ENTITY_NAME);
    helper.setEntity(userAuth);
    Response response = serviceLogin.getResponse();
    return ResponseEntity.status(response.getHttpStatus()).body(response.getBody());
  }
}