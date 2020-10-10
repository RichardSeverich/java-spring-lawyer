package com.lawyer.services;

import com.lawyer.helpers.Helper;
import com.lawyer.models.SubProcessType;
import com.lawyer.repository.RepositorySubProcessType;
import com.lawyer.responses.Response;
import com.lawyer.responses.ResponseBuilder;
import com.lawyer.services.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
* Service.
*/
@Service
public class ServiceSubProcessType implements IService {

  @Autowired
  private Helper<SubProcessType> helper;

  @Autowired
  private ResponseBuilder<SubProcessType> responseBuilder;

  @Autowired
  private RepositorySubProcessType repositorySubProcessType;

  /**
  * {@inheritDoc}
  */
  @Override
  public Response getResponse() {
    Iterable<SubProcessType> iterable =
        repositorySubProcessType.findSubProcessType(helper.getId());
    iterable.forEach(helper.getList()::add);
    return responseBuilder.getResponseOkForGet();
  }
}
