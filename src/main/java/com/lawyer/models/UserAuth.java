package com.lawyer.models;

import com.lawyer.support.Magic;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

/**
* Class.
*/
public class UserAuth {

  @NotNull
  @Size(min = Magic.TRHEE, max = Magic.TEN)
  @Getter @Setter
  private String username;

  @NotNull
  @Size(min = Magic.TRHEE, max = Magic.TEN)
  @Getter @Setter
  private String password;

  @Getter @Setter
  private String token;

  /**
  * Constructor.
  */
  public UserAuth() {
  }
}
