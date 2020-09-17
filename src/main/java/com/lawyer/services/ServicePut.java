package com.lawyer.services;

import com.lawyer.helpers.Helper;
import com.lawyer.repository.RepositoryFactory;
import com.lawyer.responses.Response;
import com.lawyer.responses.ResponseBuilder;
import com.lawyer.services.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

/**
* Service.
*/
@Service
public class ServicePut<T> implements IService {

  @Autowired
  private Helper<T> helper;

  @Autowired
  private ResponseBuilder<T> responseBuilder;

  @Autowired
  private RepositoryFactory repositoryFactory;

  /**
  * {@inheritDoc}
  */
  @Override
  public Response getResponse() {
    JpaRepository repository = repositoryFactory.getRepository(helper.getEntityName());
    Integer id = helper.getId();
    T entityExist = (T) repository.findById(id).orElse(null);
    // Negative scenario
    if (entityExist == null) {
      return responseBuilder.getResponseNotFound();
    }
    // Positive scenario
    T entity = helper.getEntity();
    helper.getList().add(entity);
    try {
      repository.save(entity);
      return responseBuilder.getResponseOkForPut();
    } catch (DataAccessException ex) {
      helper.setDataAccessException(ex.getMostSpecificCause().getMessage());
      return responseBuilder.getResponseDataAccessException();
    }
  }
}
