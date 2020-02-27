package com.satooru.jasonSays.repository.interfaces;

import com.satooru.jasonSays.model.Quote;

public interface QuoteRepositoryCustom {
    Quote findRandomQuote();
    Quote findLatestQuote();
    void delete(String quote);
}
