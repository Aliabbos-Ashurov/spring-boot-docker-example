package com.abbos.dockerexample.repository;

import com.abbos.dockerexample.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Aliabbos Ashurov
 * @since 03/December/2024  17:28
 **/
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

    boolean existsByUsername(String username);
}
