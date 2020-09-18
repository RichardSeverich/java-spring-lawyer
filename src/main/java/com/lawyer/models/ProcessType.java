package com.lawyer.models;

import com.lawyer.support.Magic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

/**
 * Class.
 */
@Entity
@Table(name = "process_type")
public class ProcessType {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  @Getter @Setter
  private Integer id;

  @NotNull
  @Id
  @Column(name = "id_matter")
  @Getter @Setter
  private Integer idMatter;

  @NotNull
  @Size(min = Magic.TRHEE, max = Magic.THIRTY)
  @Column(name = "name")
  @Getter @Setter
  private String name;

  /**
  * Constructor.
  */
  public ProcessType() {
  }
}
