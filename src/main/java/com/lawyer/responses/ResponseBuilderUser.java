package com.lawyer.responses;

import com.lawyer.models.User;
import com.lawyer.helpers.HelperUser;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Scope;
//import org.springframework.web.context.annotation.RequestScope;
//import org.springframework.web.context.WebApplicationContext;

/**
 * Response Builder.
 */
@Component
//@RequestScope
//@Scope(WebApplicationContext.SCOPE_REQUEST)
public final class ResponseBuilderUser {

    @Autowired
    private HelperUser helperUser;

    /**
     * Constructor.
     */
    private ResponseBuilderUser() {

    }

    /**
     * @return responses.
     */
    public Response<User> getResponseOkForGet() {
        Response<User> response = ResponseManager.getResponseUser();
        response
                .setHttpStatus(HttpStatus.OK)
                .getBody()
                .setTextMessage(ResponseMessage.getSuccessfully(helperUser.getEntityName()))
                .setData(helperUser.getList());
        return response;
    }

    /**
     * @return responses.
     */
    public Response<User> getResponseOkForPost() {
        Response<User> response = ResponseManager.getResponseUser();
        response
                .setHttpStatus(HttpStatus.CREATED)
                .getBody()
                .setTextMessage(ResponseMessage.createdSuccessfully(helperUser.getEntityName()))
                .setData(helperUser.getList());
        return response;
    }

    /**
     * @return responses.
     */
    public Response<User> getResponseOkForPut() {
        Response<User> response = ResponseManager.getResponseUser();
        response
                .setHttpStatus(HttpStatus.OK)
                .getBody()
                .setTextMessage(ResponseMessage.updatedSuccessfully(helperUser.getEntityName()))
                .setData(helperUser.getList());
        return response;
    }

    /**
     * @return responses.
     */
    public Response<User> getResponseOkForDelete() {
        Response<User> response = ResponseManager.getResponseUser();
        response
                .setHttpStatus(HttpStatus.OK)
                .getBody()
                .setTextMessage(ResponseMessage.deletedSuccessfully(helperUser.getEntityName()))
                .setData(helperUser.getEmptyList());
        return response;
    }

    /**
     * @return responses.
     */
    public Response<User> getResponseConflict() {
        Response<User> response = ResponseManager.getResponseUser();
        response
                .setHttpStatus(HttpStatus.CONFLICT)
                .getBody()
                .setTextMessage(ResponseMessage.entityAlreadyExist(helperUser.getEntityName()))
                .setData(helperUser.getEmptyList());
        return response;
    }

    /**
     * @return responses.
     */
    public Response<User> getResponseNotFound() {
        Response<User> response = ResponseManager.getResponseUser();
        response
                .setHttpStatus(HttpStatus.NOT_FOUND)
                .getBody()
                .setTextMessage(ResponseMessage.entityNotFound(helperUser.getEntityName()))
                .setData(helperUser.getEmptyList());
        return response;
    }

    /**
     * @return responses.
     */
    public Response<User> getResponseConflictEntityHasRelations() {
        Response<User> response = ResponseManager.getResponseUser();
        response
                .setHttpStatus(HttpStatus.CONFLICT)
                .getBody()
                .setTextMessage(ResponseMessage.entityHasRelation(helperUser.getEntityName()))
                .setData(helperUser.getEmptyList());
        return response;
    }
}
