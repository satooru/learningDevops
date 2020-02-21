package com.satooru.jasonSays.service;

import java.util.List;

import com.satooru.jasonSays.model.Quote;

public interface QuoteService {
    Quote findRandomQuote();
    Quote findLatestQuote();
    List<Quote> findAll();
    void saveQuote(Quote quote);
    void deleteQuote(int number);
}
