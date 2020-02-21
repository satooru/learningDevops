package com.satooru.jasonSays.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.SampleOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.satooru.jasonSays.model.Quote;
import com.satooru.jasonSays.repository.interfaces.QuoteRepository;

@Service
public class QuoteServiceImpl implements QuoteService {

    @Autowired
    private QuoteRepository quoteRepository;

    public Quote findRandomQuote() {
        return quoteRepository.findRandomQuote();
    }

    public Quote findLatestQuote() {
        return quoteRepository.findLatestQuote();
    }

    @Override
    public List<Quote> findAll() {
        return quoteRepository.findAll();
    }

    @Override
    public void saveQuote(Quote quote) {
        quoteRepository.save(quote);
//        mongoTemplate.save(quote);
    }

    @Override
    public void deleteQuote(int number) {
        quoteRepository.delete(number);
    }
}
