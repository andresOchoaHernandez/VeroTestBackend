package com.andresochoahernandez.verotest.repository.agents;

import com.andresochoahernandez.verotest.model.agents.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer>{
    Optional<User> findByUsername(String username);
}
