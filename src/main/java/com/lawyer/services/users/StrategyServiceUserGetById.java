package com.lawyer.services.users;

import com.lawyer.helpers.HelperUser;
import com.lawyer.models.User;
import com.lawyer.repository.RepositoryUser;
import com.lawyer.responses.ResponseBuilderUser;
import com.lawyer.services.StrategyService;
import com.lawyer.responses.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Service.
 */
@Service
public class StrategyServiceUserGetById implements StrategyService {

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
        if (user != null) {
            //helperUser.getEmptyList().add(user);
            return responseBuilderUser.getResponseOkForGet();
        } else {
            return responseBuilderUser.getResponseNotFound();
        }
    }
}
