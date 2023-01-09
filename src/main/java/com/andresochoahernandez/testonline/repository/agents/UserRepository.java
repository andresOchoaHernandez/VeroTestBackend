package com.andresochoahernandez.testonline.repository.agents;

import com.andresochoahernandez.testonline.model.agents.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer>{
    Optional<User> findByUsername(String username);
}
