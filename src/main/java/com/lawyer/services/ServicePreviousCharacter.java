package com.lawyer.services;

import com.lawyer.helpers.Helper;
import com.lawyer.models.PreviousCharacter;
import com.lawyer.repository.RepositoryPreviousCharacter;
import com.lawyer.responses.Response;
import com.lawyer.responses.ResponseBuilder;
import com.lawyer.services.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
* Service.
*/
@Service
public class ServicePreviousCharacter implements IService {

  @Autowired
  private Helper<PreviousCharacter> helper;

  @Autowired
  private ResponseBuilder<PreviousCharacter> responseBuilder;

  @Autowired
  private RepositoryPreviousCharacter repositoryPreviousCharacter;

  /**
  * {@inheritDoc}
  */
  @Override
  public Response getResponse() {
    Iterable<PreviousCharacter> iterable =
        repositoryPreviousCharacter.findPreviousCharacter(helper.getId());
    iterable.forEach(helper.getList()::add);
    return responseBuilder.getResponseOkForGet();
  }
}
