package com.portfolio.backend_mystery_word.models;

import jakarta.persistence.*;

// Entity specifies that the class is for a table in a db
@Entity 

// Force the name of the table in db 
@Table(name = "words")
public class Word {

    // Specifies that the variable id is the PK and auto-increment
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Prevent to get an empty word or a duplicate word in db.
    @Column(nullable = false, unique = true)
    private String name;

    // Empty constructor that is needed to use ORM
    public Word() {}

    // Constructor with parameters to create new word in db
    public Word(String name) {
        this.name = name;
    }

    // Getters and setter to read or change the id data
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}