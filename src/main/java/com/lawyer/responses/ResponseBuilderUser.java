package com.lawyer.responses;

import com.lawyer.models.User;
import com.lawyer.helpers.Helper;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

/**
 * Response Builder.
 */
@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ResponseBuilderUser {

    @Autowired
    private Helper<User> helper;

    Response<User> response;

    /**
     * Constructor.
     */
    public  ResponseBuilderUser() {
       this.response = new Response<>();
    }

    /**
     * @return responses.
     */
    public Response<User> getResponseOkForGet() {
        helper.setEntityName("user");
        this.response
                .setHttpStatus(HttpStatus.OK)
                .getBody()
                .setTextMessage(ResponseMessage.getSuccessfully(helper.getEntityName()))
                .setData(helper.getList());
        return response;
    }

    /**
     * @return responses.
     */
    public Response<User> getResponseOkForPost() {
        helper.setEntityName("user");
        this.response
                .setHttpStatus(HttpStatus.CREATED)
                .getBody()
                .setTextMessage(ResponseMessage.createdSuccessfully(helper.getEntityName()))
                .setData(helper.getList());
        return response;
    }

    /**
     * @return responses.
     */
    public Response<User> getResponseOkForPut() {
        helper.setEntityName("user");
        this.response
                .setHttpStatus(HttpStatus.OK)
                .getBody()
                .setTextMessage(ResponseMessage.updatedSuccessfully(helper.getEntityName()))
                .setData(helper.getList());
        return response;
    }

    /**
     * @return responses.
     */
    public Response<User> getResponseOkForDelete() {
        helper.setEntityName("user");
        this.response
                .setHttpStatus(HttpStatus.OK)
                .getBody()
                .setTextMessage(ResponseMessage.deletedSuccessfully(helper.getEntityName()))
                .setData(helper.getList());
        return response;
    }

    /**
     * @return responses.
     */
    public Response<User> getResponseConflict() {
        helper.setEntityName("user");
        this.response
                .setHttpStatus(HttpStatus.CONFLICT)
                .getBody()
                .setTextMessage(ResponseMessage.entityAlreadyExist(helper.getEntityName()))
                .setData(helper.getList());
        return response;
    }

    /**
     * @return responses.
     */
    public Response<User> getResponseNotFound() {
        helper.setEntityName("user");
        this.response
                .setHttpStatus(HttpStatus.NOT_FOUND)
                .getBody()
                .setTextMessage(ResponseMessage.entityNotFound(helper.getEntityName()))
                .setData(helper.getList());
        return response;
    }

    /**
     * @return responses.
     */
    public Response<User> getResponseConflictEntityHasRelations() {
        helper.setEntityName("user");
        this.response
                .setHttpStatus(HttpStatus.CONFLICT)
                .getBody()
                .setTextMessage(ResponseMessage.entityHasRelation(helper.getEntityName()))
                .setData(helper.getList());
         return this.response;
    }
}
