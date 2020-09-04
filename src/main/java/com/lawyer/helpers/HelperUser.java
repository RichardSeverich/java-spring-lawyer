package com.lawyer.helpers;

import com.lawyer.models.User;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

/**
 * Helper Class.
 */
@Component
//@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
//@Scope("request")
public class HelperUser {

    private static final String ENTITY_NAME = "user";
    private String id;
    private User user;
    private List<User> userList;

    /**
     * Constructor.
     */
    public HelperUser() {
        userList = new ArrayList<>();
    }

    /**
     * @return id.
     */
    public String getId() {
        return this.id;
    }

    /**
     * @param id id.
     */
    public void setId(final String id) {
        this.id = id;
    }

    /**
     * @return user.
     */
    public User getEntity() {
        return this.user;
    }

    /**
     * @param user user.
     */
    public void setEntity(final User user) {
        this.user = user;
    }

    /**
     * @return ENTITY_NAME.
     */
    public static String getEntityName() {
        return ENTITY_NAME;
    }

    /**
     * @return userList.
     */
    public List<User> getList() {
        return this.userList;
    }

    /**
     * @return userList.
     */
    public List<User> getEmptyList() {
        this.userList.clear();
        return this.userList;
    }
}
