package com.lawyer.services;

import com.lawyer.helpers.Helper;
import com.lawyer.models.User;
import com.lawyer.models.UserAuth;
import com.lawyer.repository.RepositoryUsers;
import com.lawyer.responses.Response;
import com.lawyer.responses.ResponseBuilder;
import com.lawyer.security.JWTToken;
import com.lawyer.services.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
* Service.
*/
@Service
public class ServiceLogin implements IService {

  @Autowired
  private Helper<UserAuth> helper;

  @Autowired
  private ResponseBuilder<UserAuth> responseBuilder;

  @Autowired
  private RepositoryUsers repositoryUsers;

  /**
  * {@inheritDoc}
  */
  @Override
  public Response getResponse() {
    String username = helper.getEntity().getUsername();
    String password = helper.getEntity().getPassword();
    Iterable<User> iterable = repositoryUsers.findUsers(username, password);
    boolean isEmpty = iterable.iterator().hasNext();
    // Negative scenario
    if (!isEmpty) {
      return responseBuilder.getResponseNotFound();
    }
    // Positive scenario
    helper.getEntity().setToken(JWTToken.getJWTToken(username));
    helper.getList().add(helper.getEntity());
    return responseBuilder.getResponseOkForGet();
  }
}
