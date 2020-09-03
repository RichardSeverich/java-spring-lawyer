package com.lawyer.support;

/**
 * Constants Paths utility class.
 */
public final class Paths {

    private static final String VERSION = "/api/v1";
    private static final String USER = "/users";
    private static final String ITEM = "/items";
    private static final String SALE = "/sales";
    private static final String SALE_ITEM = "/sales/items";
    private static final String ID = "/{id}";
    // Users
    public static final String PATH_USERS = VERSION + USER;
    public static final String PATH_USERS_WITH_ID = PATH_USERS + ID;
    // Items
    public static final String PATH_ITEMS = VERSION + ITEM;
    public static final String PATH_ITEMS_WITH_ID = PATH_ITEMS + ID;
    // Sales
    public static final String PATH_SALES = VERSION + SALE;
    public static final String PATH_SALES_WITH_ID = PATH_SALES + ID;
    // Sales Items
    public static final String PATH_SALE_ITEMS = VERSION + SALE_ITEM;
    public static final String PATH_SALE_ITEMS_WITH_ID = PATH_SALE_ITEMS + ID;

    /**
     * Private constructor for utility class.
     */
    private Paths() {

    }
}
