package com.lawyer.repository;

import com.lawyer.models.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Interface.
 */
@Repository
public interface RepositoryPersons extends RepositoryGeneric<Person> {

  @Query(value = "SELECT persons.* FROM persons "
      + "INNER JOIN person_demandant "
      + "ON persons.id=person_demandant.id_person "
      + "WHERE person_demandant.id_process = ?1", nativeQuery = true)
  Iterable<Person> findPersonDemandant(Integer processId);

  @Query(value = "SELECT persons.* FROM persons "
      + "INNER JOIN person_defendant "
      + "ON persons.id=person_defendant.id_person "
      + "WHERE person_defendant.id_process = ?1", nativeQuery = true)
  Iterable<Person> findPersonDefendant(Integer processId);
}
