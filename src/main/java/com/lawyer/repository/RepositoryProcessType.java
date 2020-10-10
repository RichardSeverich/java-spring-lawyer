package com.lawyer.repository;

import com.lawyer.models.ProcessType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Interface.
 */
@Repository
public interface RepositoryProcessType extends RepositoryGeneric<ProcessType> {

  @Query(value = "SELECT * FROM process_type "
      + "WHERE process_type.id_matter = ?1 ", nativeQuery = true)
  Iterable<ProcessType> findProcessType(Integer processId);
}
