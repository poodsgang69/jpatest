package com.test.jpatest.repo;

import com.test.jpatest.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query ("SELECT u.name from User u where u.name = ?1")
    String getByName(String name);

    @Query ("SELECT u.email from User u where u.email = ?1")
    String getByEmail(String email);

    User test(String name);

}
