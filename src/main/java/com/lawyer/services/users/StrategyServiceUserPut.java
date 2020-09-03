package com.lawyer.services.users;

import com.lawyer.helpers.HelperUser;
import com.lawyer.models.User;
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
public class StrategyServiceUserPut implements StrategyService {

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
        User user = repositoryUser.findById(helperUser.getId()).orElse(null);
        helperUser.getEmptyList().add(helperUser.getEntity());
        // If user not exist.
        if (user != null) {
            repositoryUser.save(helperUser.getEntity());
            return responseBuilderUser.getResponseOkForPut();
        }
        return responseBuilderUser.getResponseNotFound();
    }
}
