package com.lawyer.services.strategies;

import com.lawyer.helpers.Helper;
import com.lawyer.responses.ResponseBuilder;
import com.lawyer.services.StrategyService;
import com.lawyer.responses.Response;
import com.lawyer.repository.RepositoryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Service.
 */
@Service
public class StrategyPut<T> implements StrategyService {

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
        repository.save(entity);
        helper.getList().add(entity);
        return responseBuilder.getResponseOkForPut();
    }
}
