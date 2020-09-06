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
        T entity = repository.findById(id).orElse(null);
        helper.getList().add(entity);
        // Negative scenario
        if (entity == null) {
           return responseBuilder.getResponseNotFound();    
        }
        // Positive scenario
        repository.save(entity);
        return responseBuilder.getResponseOkForPut();
    }
}
