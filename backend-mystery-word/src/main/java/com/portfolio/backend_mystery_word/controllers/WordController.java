package com.portfolio.backend_mystery_word.controllers;

import com.portfolio.backend_mystery_word.models.Word;
import com.portfolio.backend_mystery_word.repositories.WordRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

// Inform Spring boot that this is a Controller and an API that return text and JSON
@RestController
// Define the URL consume by the front to call this controller
@RequestMapping("/api/randomWord")
// Allow the front to interact with our API
@CrossOrigin(origins = "*")
public class WordController {

    // Declare the server needed by the controller to interact with DB
    private final WordRepository wordRepository;

    // Constructor of the controller that needs its methods and server
    public WordController(WordRepository wordRepository) {
        this.wordRepository = wordRepository;
    }

    // A request in GET will consume this method
    @GetMapping
    public Word getRandomWord() {

        // Get all the words in the DB
        List<Word> allWords = wordRepository.findAll();

    }
}