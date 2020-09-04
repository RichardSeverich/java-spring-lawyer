package com.lawyer.repository;

import com.lawyer.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface.
 */
@Repository
public interface RepositoryUser extends JpaRepository<User, String> {

}
