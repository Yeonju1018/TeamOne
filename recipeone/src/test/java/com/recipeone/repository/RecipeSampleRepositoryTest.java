package com.recipeone.repository;

import com.recipeone.entity.RecipeSample;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class RecipeSampleRepositoryTest {

    @Autowired
    private RecipeSampleRepository recipeSampleRepository;

    @Test
    public void insertRecipeSamples() {
        IntStream.rangeClosed(1, 10).forEach(i -> {
            RecipeSample recipeSample = RecipeSample.builder()
                    .id(String.valueOf(i))
                    .title(i <= 5 ? "test" + i : "title" + i)
                    .tag(i <= 3 ? "감자" : i <= 6 ? "고구마" : "김치")
                    .build();
            recipeSampleRepository.save(recipeSample);
        });
    }
}