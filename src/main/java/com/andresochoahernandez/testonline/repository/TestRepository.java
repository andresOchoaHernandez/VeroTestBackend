package com.andresochoahernandez.testonline.repository;

import com.andresochoahernandez.testonline.model.Test;
import com.andresochoahernandez.testonline.model.TestPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<Test,TestPK> {
}
