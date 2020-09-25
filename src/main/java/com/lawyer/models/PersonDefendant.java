package com.lawyer.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

/**
 * Class.
 */
@Entity
@Table(name = "person_defendant")
public class PersonDefendant {

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
  @Column(name = "id_person")
  @Getter @Setter
  private Integer idPerson;

  /**
  * Constructor.
  */
  public PersonDefendant() {
  }
}
