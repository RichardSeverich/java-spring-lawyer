package com.lawyer.support;

/**
* Constants Paths utility class.
*/
public final class Paths {

  private static final String VERSION = "/api/v1";
  private static final String USER = "/users";
  private static final String PERSON = "/persons";
  private static final String PROCESS = "/process";
  private static final String PERSON_DEMANDANT = "/person-demandant";
  private static final String PERSON_DEFENDANT = "/person-defendant";
  private static final String PREVIOUS_CHARACTER = "/previous-character";
  private static final String MATTER = "/matter";
  private static final String PROCESS_TYPE = "/process-type";
  private static final String SUB_PROCESS_TYPE = "/sub-process-type";
  private static final String LOGIN = "/login";
  private static final String ID = "/{id}";
  // Login
  public static final String PATH_LOGIN = VERSION + LOGIN;
  // Users
  public static final String PATH_USERS = VERSION + USER;
  public static final String PATH_USERS_WITH_ID = PATH_USERS + ID;
  // Person
  public static final String PATH_PERSON = VERSION + PERSON;
  public static final String PATH_PERSON_WITH_ID = PATH_PERSON + ID;
  // Process
  public static final String PATH_PROCESS = VERSION + PROCESS;
  public static final String PATH_PROCESS_WITH_ID = PATH_PROCESS + ID;
  // Person Demandant
  public static final String PATH_PERSON_DEMANDANT = VERSION + PERSON_DEMANDANT;
  public static final String PATH_PERSON_DEMANDANT_WITH_ID = PATH_PERSON_DEMANDANT + ID;
  // Person Defendant
  public static final String PATH_PERSON_DEFENDANT = VERSION + PERSON_DEFENDANT;
  public static final String PATH_PERSON_DEFENDANT_WITH_ID = PATH_PERSON_DEFENDANT + ID;
  // Previous Character
  public static final String PATH_PREVIOUS_CHARACTER = VERSION + PREVIOUS_CHARACTER;
  public static final String PATH_PREVIOUS_CHARACTER_WITH_ID = PATH_PREVIOUS_CHARACTER + ID;
  // Matter
  public static final String PATH_MATTER = VERSION + MATTER;
  public static final String PATH_MATTER_WITH_ID = PATH_MATTER + ID;
  // Process Type
  public static final String PATH_PROCESS_TYPE = VERSION + PROCESS_TYPE;
  public static final String PATH_PROCESS_TYPE_WITH_ID = PATH_PROCESS_TYPE + ID;
  // Sub Process Type
  public static final String PATH_SUB_PROCESS_TYPE = VERSION + SUB_PROCESS_TYPE;
  public static final String PATH_SUB_PROCESS_TYPE_WITH_ID = PATH_SUB_PROCESS_TYPE + ID;
  // Process Person
  public static final String PROCESS_PERSON_DEMANDANT = VERSION + PROCESS + ID + PERSON_DEMANDANT;
  public static final String PROCESS_PERSON_DEFENDANT = VERSION + PROCESS + ID + PERSON_DEFENDANT;
  // Process Previous Character
  public static final String PROCESS_PREVIOUS_CHARACTER =
      VERSION + PROCESS + ID + PREVIOUS_CHARACTER;
  // Matter Proces Type
  public static final String MATTER_PROCESS_TYPE = VERSION + MATTER + ID + PROCESS_TYPE;
  // Proces Type Sub Process Type
  public static final String PROCESS_TYPE_SUB_PROCESS_TYPE =
      VERSION + PROCESS_TYPE + ID + SUB_PROCESS_TYPE;

  /**
  * Private constructor for utility class.
  */
  private Paths() {

  }
}
