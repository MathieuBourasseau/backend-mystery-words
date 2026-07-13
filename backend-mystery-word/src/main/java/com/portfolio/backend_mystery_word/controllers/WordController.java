package com.portfolio.backend_mystery_word.controllers;

import com.portfolio.backend_mystery_word.models.Word;
import com.portfolio.backend_mystery_word.repositories.WordRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Inform Spring boot that this is a Controller and an API that return text and JSON
@RestController
// Define the URL consume by the front to call this controller
@RequestMapping("/api/words")
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
    public List<Word> getAllWords() {
        return wordRepository.findAll();
    }
}