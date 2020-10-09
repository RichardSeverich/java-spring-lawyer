package com.lawyer.services;

import com.lawyer.helpers.Helper;
import com.lawyer.models.Person;
import com.lawyer.repository.RepositoryPersons;
import com.lawyer.responses.Response;
import com.lawyer.responses.ResponseBuilder;
import com.lawyer.services.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
* Service.
*/
@Service
public class ServicePersonsDefendant implements IService {

  @Autowired
  private Helper<Person> helper;

  @Autowired
  private ResponseBuilder<Person> responseBuilder;

  @Autowired
  private RepositoryPersons repositoryPersons;

  /**
  * {@inheritDoc}
  */
  @Override
  public Response getResponse() {
    Iterable<Person> iterable = repositoryPersons.findPersonDefendant(helper.getId());
    iterable.forEach(helper.getList()::add);
    return responseBuilder.getResponseOkForGet();
  }
}
