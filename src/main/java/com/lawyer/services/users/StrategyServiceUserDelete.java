package com.lawyer.services.users;

import com.lawyer.helpers.HelperUser;
import com.lawyer.repository.RepositoryUser;
import com.lawyer.responses.ResponseBuilderUser;
import com.lawyer.services.StrategyService;
import com.lawyer.responses.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service.
 */
@Service
public class StrategyServiceUserDelete implements StrategyService {

    @Autowired
    private RepositoryUser repositoryUser;

    @Autowired
    private HelperUser helperUser;

    @Autowired
    private ResponseBuilderUser responseBuilderUser;

    /**
     * {@inheritDoc}
     */
    @Override
    public Response getResponse() {
        if (repositoryUser.findById(helperUser.getId()).orElse(null) != null) {
            repositoryUser.deleteById(helperUser.getId());
            return responseBuilderUser.getResponseOkForDelete();
        }
        return responseBuilderUser.getResponseNotFound();
    }
}
