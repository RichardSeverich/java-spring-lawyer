package com.lawyer.helpers;

import com.lawyer.models.User;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

import lombok.Getter;
import lombok.Setter;

/**
 * Helper Class.
 */
@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Helper<T> {

    @Getter @Setter
    private String id;
    @Getter @Setter
    private T entity;
    @Getter @Setter
    private List<T> list;

    /**
     * Constructor.
     */
    public Helper() {
        this.id = "";
        this.list = new ArrayList<>();
    }
}
