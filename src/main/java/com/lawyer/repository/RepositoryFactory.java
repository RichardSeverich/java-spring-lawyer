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

  public JpaRepository getRepository(String entityName){
    switch(entityName) {
      case "user":
        return repositoryUsers;
      case "person":
        return repositoryPersons;
      default:
        return repositoryUsers;
    }
  }
}
