package com.lawyer.repository;

import com.lawyer.models.PreviousCharacter;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Interface.
 */
@Repository
public interface RepositoryPreviousCharacter extends RepositoryGeneric<PreviousCharacter> {

  @Query(value = "SELECT previous_character.* "
      + "FROM previous_character "
      + "WHERE previous_character.id_process = ?1", nativeQuery = true)
  Iterable<PreviousCharacter> findPreviousCharacter(Integer processId);
}
