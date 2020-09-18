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
@Table(name = "person_demandant")
public class PersonDemandant {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  @Getter @Setter
  private Integer id;

  @NotNull
  @Id
  @Column(name = "id_process")
  @Getter @Setter
  private Integer idProcess;

  @NotNull
  @Id
  @Column(name = "id_person")
  @Getter @Setter
  private Integer idPerson;

  /**
  * Constructor.
  */
  public PersonDemandant() {
  }
}
