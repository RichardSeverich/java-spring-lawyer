package com.lawyer.models;

import com.lawyer.support.Magic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

/**
 * Class.
 */
@Entity
@Table(name = "previous_character")
public class PreviousCharacter {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  @Getter @Setter
  private Integer id;

  @NotNull
  @Column(name = "id_process")
  @Getter @Setter
  private Integer idProcess;

  @NotNull
  @Size(min = Magic.TEN, max = Magic.TEN)
  @Pattern(regexp = "([12]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]))")
  @Column(name = "notification_date")
  @Getter @Setter
  private String notificationDate;

  @NotNull
  @Size(min = Magic.TRHEE, max = Magic.THIRTY)
  @Column(name = "description")
  @Getter @Setter
  private String description;

  @NotNull
  @Size(min = Magic.TRHEE, max = Magic.THIRTY)
  @Pattern(regexp = "(inProgress|finished|undefined)")
  @Column(name = "state")
  @Getter @Setter
  private String state;

  @Column(name = "creation_date", insertable = false, updatable = false)
  @Getter @Setter
  private String creationDate;

  @Column(name = "update_date", insertable = false, updatable = false)
  @Getter @Setter
  private String updateDate;

  /**
  * Constructor.
  */
  public PreviousCharacter() {
  }
}
