package com.lawyer.support;

/**
 * Constants Paths utility class.
 */
public final class Paths {

    private static final String VERSION = "/api/v1";
    private static final String USER = "/users";
    private static final String PERSON = "/persons";
    private static final String ID = "/{id}";
    // Users
    public static final String PATH_USERS = VERSION + USER;
    public static final String PATH_USERS_WITH_ID = PATH_USERS + ID;
    // Person
    public static final String PATH_PERSON = VERSION + PERSON;
    public static final String PATH_PERSON_WITH_ID = PATH_PERSON + ID;

    /**
     * Private constructor for utility class.
     */
    private Paths() {

    }
}
