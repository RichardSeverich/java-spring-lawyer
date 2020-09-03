package com.lawyer.responses;

import com.lawyer.models.User;

/**
 * ResponseManager.
 */
public final class ResponseManager {

    private static ResponseManager responseManager;
    private Response<User> userResponse;

    /**
     * Constructor.
     */
    private ResponseManager() {
        userResponse = new Response<>();
    }

    /**
     * @return Singleton.
     */
    private static ResponseManager getSingleton() {
        if (responseManager == null) {
            responseManager = new ResponseManager();
        }
        return responseManager;
    }

    /**
     * @return Response.
     */
    public static Response<User> getResponseUser() {
        return getSingleton().userResponse;
    }
}
