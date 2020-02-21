package com.satooru.jasonSays.repository.interfaces;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.satooru.jasonSays.model.Quote;

public interface QuoteRepository extends PagingAndSortingRepository<Quote, String>, QuoteRepositoryCustom{
    List<Quote> findAll();
    Quote findByNumber(int number);
    Quote save(Quote quote);
}
