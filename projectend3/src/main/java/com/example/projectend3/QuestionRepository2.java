package com.example.projectend3;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository2 extends JpaRepository<Question2, Long> {
    @Query(value = "SELECT * FROM questions2 ORDER BY RAND() LIMIT 10", nativeQuery = true)
    List<Question2> findRandom10();
}
