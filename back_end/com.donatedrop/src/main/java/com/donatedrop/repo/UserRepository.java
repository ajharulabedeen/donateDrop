package com.donatedrop.repo;

import com.donatedrop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.zerhusen.model.security.User;


/**
 * Created by stephan on 20.03.16.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
