package com.lawyer.services;

import com.lawyer.helpers.Helper;
import com.lawyer.models.ProcessType;
import com.lawyer.repository.RepositoryProcessType;
import com.lawyer.responses.Response;
import com.lawyer.responses.ResponseBuilder;
import com.lawyer.services.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
* Service.
*/
@Service
public class ServiceProcessType implements IService {

  @Autowired
  private Helper<ProcessType> helper;

  @Autowired
  private ResponseBuilder<ProcessType> responseBuilder;

  @Autowired
  private RepositoryProcessType repositoryProcessType;

  /**
  * {@inheritDoc}
  */
  @Override
  public Response getResponse() {
    Iterable<ProcessType> iterable =
        repositoryProcessType.findProcessType(helper.getId());
    iterable.forEach(helper.getList()::add);
    return responseBuilder.getResponseOkForGet();
  }
}
