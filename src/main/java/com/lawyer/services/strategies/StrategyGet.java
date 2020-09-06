package com.lawyer.services.strategies;

import com.lawyer.helpers.Helper;
import com.lawyer.repository.RepositoryEntity;
import com.lawyer.responses.ResponseBuilder;
import com.lawyer.services.StrategyService;
import com.lawyer.responses.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Service.
 */
@Service
public class StrategyGet<T> implements StrategyService {

    @Autowired
    private RepositoryEntity<T> repository;

    @Autowired
    private Helper<T> helper;

    @Autowired
    private ResponseBuilder<T> responseBuilder;

    /**
     * {@inheritDoc}
     */
    @Override
    public Response getResponse() {
        //repository = new RepositoryEntity();
        Iterable<T> iterable = this.repository.findAll();
        iterable.forEach(helper.getList()::add);
        return responseBuilder.getResponseOkForGet();
    }
}
