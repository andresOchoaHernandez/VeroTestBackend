package com.andresochoahernandez.testonline.repository;

import com.andresochoahernandez.testonline.model.InTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Timestamp;
import java.util.Optional;

public interface InTestRepository extends JpaRepository<InTest, Integer> {
}
