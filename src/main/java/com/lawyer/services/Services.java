package com.lawyer.services;

import com.lawyer.helpers.Helper;
import com.lawyer.models.User;
import com.lawyer.responses.Response;
import com.lawyer.services.strategies.StrategyDelete;
import com.lawyer.services.strategies.StrategyGet;
import com.lawyer.services.strategies.StrategyGetById;
import com.lawyer.services.strategies.StrategyPost;
import com.lawyer.services.strategies.StrategyPut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* Services.
*/
@Service
public class Services<T> {

  private StrategyManager strategyManager;

  // Import Strategies
  @Autowired
  private StrategyGet<T> strategyGet;

  @Autowired
  private StrategyGetById<T> strategyGetById;

  @Autowired
  private StrategyPost<T> strategyPost;

  @Autowired
  private StrategyPut<T> strategyPut;

  @Autowired
  private StrategyDelete<T> strategyDelete;

  @Autowired
  private Helper<T> helper;

  /**
  * Constructor.
  */
  Services() {
    strategyManager = new StrategyManager();
  }

  /**
  * @return Response.
  */
  public Response getAll() {
    return strategyManager.getResponse(strategyGet);
  }

  /**
  * @param id id.
  * @return Response.
  */
  public Response getById(final Integer id) {
    helper.setId(id);
    return strategyManager.getResponse(strategyGetById);
  }

  /**
  * @param entity entity.
  * @return Response.
  */
  public Response add(final T entity) {
    helper.setEntity(entity);
    return strategyManager.getResponse(strategyPost);
  }

  /**
  * @param entity entity.
  * @param id   id.
  * @return Response.
  */
  public Response update(final T entity, final Integer id) {
    helper.setId(id);
    helper.setEntity(entity);
    return strategyManager.getResponse(strategyPut);
  }

  /**
  * @param id id.
  * @return Response.
  */
  public Response delete(final Integer id) {
    helper.setId(id);
    return strategyManager.getResponse(strategyDelete);
  }
}
