package com.portfolio.backend_mystery_word.repositories;

import com.portfolio.backend_mystery_word.models.Word;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Precise to Spring Boot that this is a Repository
@Repository
public interface WordRepository extends JpaRepository<Word, Long> { 

    // Create automatic methods from JpaRepository like :
        // save(word);
        // findAll():
        // deleteById(id)
    
}