package com.lawyer.services.strategies;

import com.lawyer.helpers.Helper;
import com.lawyer.responses.ResponseBuilder;
import com.lawyer.services.StrategyService;
import com.lawyer.responses.Response;
import com.lawyer.repository.RepositoryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Service.
 */
@Service
public class StrategyGet<T> implements StrategyService {

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
        Iterable<T> iterable = repository.findAll();
        iterable.forEach(helper.getList()::add);
        return responseBuilder.getResponseOkForGet();
    }
}
