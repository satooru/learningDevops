package com.satooru.jasonSays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.satooru.jasonSays.model.Quote;
import com.satooru.jasonSays.repository.interfaces.QuoteRepository;

@SpringBootApplication
public class JasonSaysApplication implements CommandLineRunner {

    @Autowired
    private QuoteRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(JasonSaysApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        repository.deleteAll();
        System.out.println(repository.count());
        repository.save(new Quote(1, "Just Do it!"));
        System.out.println(repository.count());
    }
}
