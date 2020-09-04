package com.lawyer.responses;

import com.lawyer.models.User;
import com.lawyer.helpers.Helper;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import lombok.Setter;

/**
 * Response Builder.
 */
@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ResponseBuilder<T> {

    @Autowired
    private Helper<T> helper;

    @Setter
    private String entityName;

    private Response<T> response;

    private String message;

    /**
     * Constructor.
     */
    public  ResponseBuilder() {
       this.response = new Response<>();
       this.message = "";
       this.entityName = "entity";
    }

    /**
    * Build Body.
     */
    private void buildBody(){
        this.response.getBody().setMessage(this.message);
        this.response.getBody().setData(helper.getList());
    }

    /**
     * @return responses.
     */
    public Response<T> getResponseOkForGet() {
        this.response.setHttpStatus(HttpStatus.OK);
        this.message = ResponseMessage.getSuccessfully(entityName);
        this.buildBody();
        return response;
    }

    /**
     * @return responses.
     */
    public Response<T> getResponseOkForPost() {
        this.response.setHttpStatus(HttpStatus.CREATED);
        this.message = ResponseMessage.createdSuccessfully(entityName);
        this.buildBody();
        return response;
    }

    /**
     * @return responses.
     */
    public Response<T> getResponseOkForPut() {
        this.response.setHttpStatus(HttpStatus.OK);
        this.message = ResponseMessage.updatedSuccessfully(entityName);
        this.buildBody();
        return response;
    }

    /**
     * @return responses.
     */
    public Response<T> getResponseOkForDelete() {
        this.response.setHttpStatus(HttpStatus.OK);
        this.message = ResponseMessage.deletedSuccessfully(entityName);
        this.buildBody();
        return response;
    }

    /**
     * @return responses.
     */
    public Response<T> getResponseConflict() {
        this.response.setHttpStatus(HttpStatus.CONFLICT);
        this.message = ResponseMessage.entityAlreadyExist(entityName);
        this.buildBody();
        return response;
    }

    /**
     * @return responses.
     */
    public Response<T> getResponseNotFound() {
        this.response.setHttpStatus(HttpStatus.NOT_FOUND);
        this.message = ResponseMessage.entityNotFound(entityName);
        this.buildBody();
        return response;
    }

    /**
     * @return responses.
     */
    public Response<T> getResponseConflictEntityHasRelations() {
        this.response.setHttpStatus(HttpStatus.CONFLICT);
        this.message = ResponseMessage.entityHasRelation(entityName);
        this.buildBody();
        return this.response;
    }
}
