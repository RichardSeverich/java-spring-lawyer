package com.lawyer.services.strategies;

import com.lawyer.helpers.Helper;
import com.lawyer.repository.RepositoryFactory;
import com.lawyer.responses.Response;
import com.lawyer.responses.ResponseBuilder;
import com.lawyer.services.StrategyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


/**
* Service.
*/
@Service
public class StrategyGetById<T> implements StrategyService {

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
    T entity = (T) repository.findById(helper.getId()).orElse(null);
    // Negative scenario
    if (entity == null) {
      return responseBuilder.getResponseNotFound();
    }
    // Positive scenario
    helper.getList().add(entity);
    return responseBuilder.getResponseOkForGet();
  }
}
