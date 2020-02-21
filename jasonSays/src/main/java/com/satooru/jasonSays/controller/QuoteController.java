package com.satooru.jasonSays.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.satooru.jasonSays.model.Quote;
import com.satooru.jasonSays.service.QuoteService;

@RestController
@RequestMapping
public class QuoteController {

    @Autowired
    private QuoteService quoteService;

    @GetMapping("/")
    public Quote findRandomQuote() {
        return quoteService.findRandomQuote();
//        return new Quote("1", "Don't let dreams be dreams");
    }

    @GetMapping("/latest")
    public Quote findLatestQuote() {
        return quoteService.findLatestQuote();
    }

    @GetMapping("/all")
    public List<Quote> findAll() {
        return quoteService.findAll();
    }

    @PostMapping("/")
    public ResponseEntity<?> upsertQuote(@RequestBody Quote quote) {
        quoteService.saveQuote(quote);
        return new ResponseEntity("Quote added successfully", HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteQuote(@PathVariable int number) {
        quoteService.deleteQuote(number);
    }
}
