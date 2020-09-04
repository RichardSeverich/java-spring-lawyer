package com.lawyer.services;

import com.lawyer.models.User;
import com.lawyer.responses.Response;
import com.lawyer.helpers.HelperUser;
import com.lawyer.services.users.StrategyServiceUserDelete;
import com.lawyer.services.users.StrategyServiceUserGet;
import com.lawyer.services.users.StrategyServiceUserGetById;
import com.lawyer.services.users.StrategyServiceUserPost;
import com.lawyer.services.users.StrategyServiceUserPut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Users Services.
 */
@Service
public class ServicesUser {

    private StrategyManager strategyManager;

    // Import Strategies
    @Autowired
    private StrategyServiceUserGet strategyGet;

    @Autowired
    private StrategyServiceUserGetById strategyGetById;

    @Autowired
    private StrategyServiceUserPost strategyPost;

    @Autowired
    private StrategyServiceUserPut strategyPut;

    @Autowired
    private StrategyServiceUserDelete strategyDelete;

    @Autowired
    private HelperUser helperUser;

    /**
     * Constructor.
     */
    ServicesUser() {
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
    public Response getById(final String id) {
        helperUser.setId(id);
        return strategyManager.getResponse(strategyGetById);
    }

    /**
     * @param user user.
     * @return Response.
     */
    public Response add(final User user) {
        helperUser.setEntity(user);
        return strategyManager.getResponse(strategyPost);
    }

    /**
     * @param user user.
     * @param id   id.
     * @return Response.
     */
    public Response update(final User user, final String id) {
        helperUser.setId(id);
        helperUser.setEntity(user);
        return strategyManager.getResponse(strategyPut);
    }

    /**
     * @param id id.
     * @return Response.
     */
    public Response delete(final String id) {
        helperUser.setId(id);
        return strategyManager.getResponse(strategyDelete);
    }
}
