package com.satooru.jasonSays.repository.interfaces.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.SampleOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.satooru.jasonSays.model.Quote;
import com.satooru.jasonSays.repository.interfaces.QuoteRepositoryCustom;

public class QuoteRepositoryCustomImpl implements QuoteRepositoryCustom{

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public Quote findRandomQuote() {
        SampleOperation sampleStage = Aggregation.sample(1);
        Aggregation aggregation = Aggregation.newAggregation(sampleStage);
        AggregationResults<Quote> quote = mongoTemplate.aggregate(aggregation, "quotes", Quote.class);
        return quote.getUniqueMappedResult();
    }

    @Override
    public Quote findLatestQuote() {
        Query query = new Query();
        query.with(Sort.by(Sort.Direction.DESC, "_id"));
        return mongoTemplate.findOne(query, Quote.class);
    }

    @Override
    public void delete(int number) {
        Query query = new Query();
        query.addCriteria(Criteria.where("number").is(number));
        mongoTemplate.findAndRemove(query, Quote.class);
    }

}
