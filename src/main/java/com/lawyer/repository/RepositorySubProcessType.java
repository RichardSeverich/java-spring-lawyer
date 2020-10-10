package com.lawyer.repository;

import com.lawyer.models.SubProcessType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Interface.
 */
@Repository
public interface RepositorySubProcessType extends RepositoryGeneric<SubProcessType> {

  @Query(value = "SELECT * FROM sub_process_type "
      + "WHERE sub_process_type.id_process_type = ?1 ", nativeQuery = true)
  Iterable<SubProcessType> findSubProcessType(Integer processId);
}
