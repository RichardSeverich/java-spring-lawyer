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
@Table(name = "persons")
public class Person {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  @Getter @Setter
  private Integer id;

  @NotNull
  @Size(min = Magic.SEVEN, max = Magic.SEVEN)
  @Column(name = "dni")
  @Getter @Setter
  private String dni;

  @NotNull
  @Size(min = Magic.TRHEE, max = Magic.THIRTY)
  @Column(name = "name")
  @Getter @Setter
  private String name;

  @NotNull
  @Size(min = Magic.TRHEE, max = Magic.THIRTY)
  @Column(name = "father_last_name")
  @Getter @Setter
  private String fatherLastName;

  @NotNull
  @Size(min = Magic.TRHEE, max = Magic.THIRTY)
  @Column(name = "mother_last_name")
  @Getter @Setter
  private String motherLastName;

  @NotNull
  @Size(min = Magic.TEN, max = Magic.TEN)
  @Pattern(regexp = "([12]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]))")
  @Column(name = "birth_date")
  @Getter @Setter
  private String birthDate;

  @NotNull
  @Size(min = Magic.TRHEE, max = Magic.THIRTY)
  @Column(name = "telephone")
  @Getter @Setter
  private String telephone;

  @NotNull
  @Size(min = Magic.TRHEE, max = Magic.SIXTY)
  @Column(name = "address")
  @Getter @Setter
  private String address;

  @Size(min = Magic.SEVEN, max = Magic.THIRTY)
  @Pattern(regexp = "^([a-zA-Z0-9_\\-.]+)@([a-zA-Z0-9_\\-.]+)\\.([a-zA-Z]{2,5})$")
  @Column(name = "email")
  @Getter @Setter
  private String email;

  @Column(name = "creation_date", insertable = false, updatable = false)
  @Getter @Setter
  private String creationDate;

  @Column(name = "update_date", insertable = false, updatable = false)
  @Getter @Setter
  private String updateDate;

  /**
  * Constructor.
  */
  public Person() {
  }
}
