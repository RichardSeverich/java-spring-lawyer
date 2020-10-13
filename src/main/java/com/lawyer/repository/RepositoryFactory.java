package com.lawyer.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class RepositoryFactory {

  @Autowired
  private RepositoryUsers repositoryUsers;

  @Autowired
  private RepositoryPersons repositoryPersons;

  @Autowired
  private RepositoryPersonDefendant repositoryPersonDefendant;

  @Autowired
  private RepositoryPersonDemandant repositoryPersonDemandant;

  @Autowired
  private RepositoryMatter repositoryMatter;

  @Autowired
  private RepositoryProcess repositoryProcess;

  @Autowired
  private RepositoryProcessType repositoryProcessType;

  @Autowired
  private RepositorySubProcessType repositorySubProcessType;

  @Autowired
  private RepositoryPreviousCharacter repositoryPreviousCharacter;

  /**
   *.
   * @param entityName.
   * @return JpaRepository.
   */
  public JpaRepository getRepository(String entityName) {
    switch (entityName) {
      case "user":
        return repositoryUsers;
      case "person":
        return repositoryPersons;
      case "matter":
        return repositoryMatter;
      case "person_defendant":
        return repositoryPersonDefendant;
      case "person_demandant":
        return repositoryPersonDemandant;
      case "previous_character":
        return repositoryPreviousCharacter;
      case "process":
        return repositoryProcess;
      case "process_type":
        return repositoryProcessType;
      case "sub_process_type":
        return repositorySubProcessType;
      default:
        return repositoryUsers;
    }
  }
}
