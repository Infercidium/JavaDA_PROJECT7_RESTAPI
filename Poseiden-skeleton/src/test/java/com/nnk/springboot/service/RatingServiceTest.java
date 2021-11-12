package com.nnk.springboot.service;

import com.nnk.springboot.domain.Rating;
import com.nnk.springboot.repositories.RatingRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.isA;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = {RatingService.class})
class RatingServiceTest {

    @MockBean
    private RatingRepository ratingR;

    @Autowired
    private RatingService ratingS;

    private final Rating rating = new Rating("moody", "sand", "fitch", 1);

    @BeforeEach
    void setUp() {
        when(ratingR.findById(isA(Integer.class))).thenReturn(java.util.Optional.of(rating));
    }

    @Test
    void postRating() {
        ratingS.postRating(rating);
        verify(ratingR, times(1)).save(rating);
    }

    @Test
    void getRating() {
        Rating ratingResult = ratingS.getRating(isA(Integer.class));
        assertEquals(rating, ratingResult);
    }

    @Test
    void getRatings() {
        when(ratingR.findAll()).thenReturn(Collections.singletonList(rating));
        List<Rating> ratingList = ratingS.getRatings();
        assertEquals(Collections.singletonList(rating), ratingList);
    }

    @Test
    void deleteRating() {
        ratingS.deleteRating(isA(Integer.class));
        verify(ratingR, times(1)).delete(rating);
    }
}