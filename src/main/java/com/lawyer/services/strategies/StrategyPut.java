package com.lawyer.services.strategies;

import com.lawyer.helpers.Helper;
import com.lawyer.repository.RepositoryEntity;
import com.lawyer.responses.ResponseBuilder;
import com.lawyer.services.StrategyService;
import com.lawyer.responses.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service.
 */
@Service
public class StrategyPut<T> implements StrategyService {

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
        Integer id = helper.getId();
        T entityExist = repository.findById(id).orElse(null);
        // Negative scenario
        if (entityExist == null) {
           return responseBuilder.getResponseNotFound();    
        }
        // Positive scenario
        T entity = helper.getEntity();
        repository.save(entity);
        helper.getList().add(entity);
        return responseBuilder.getResponseOkForPut();
    }
}
