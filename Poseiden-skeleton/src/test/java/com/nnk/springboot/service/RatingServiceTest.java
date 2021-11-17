package com.nnk.springboot.service;

import com.nnk.springboot.domain.Rating;
import com.nnk.springboot.repositories.RatingRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
        rating.setId(1);

        when(ratingR.findById(isA(Integer.class))).thenAnswer(new Answer<Optional<Rating>>() {
            /**
             * @param invocation the invocation on the mock.
             * @return the value to be returned
             */
            @Override
            public Optional<Rating> answer(InvocationOnMock invocation) {
                Integer integer = invocation.getArgument(0, Integer.class);
                if (integer == 0) {
                    return Optional.empty();
                }
                return Optional.of(rating);
            }
        });
    }

    @Test
    void postRating() {
        ratingS.postRating(rating);
        verify(ratingR, times(1)).save(rating);
    }

    @Test
    void updateRating() {
        ratingS.updateRating(rating, 1);
        verify(ratingR, times(1)).save(rating);
        assertEquals(1, rating.getId());
    }

    @Test
    void getRating() {
        Rating ratingResult = ratingS.getRating(1);
        assertEquals(rating, ratingResult);
    }

    @Test
    void getRatingFail() {
        assertThrows(IllegalArgumentException.class, ()->ratingS.getRating(0));
    }

    @Test
    void getRatings() {
        when(ratingR.findAll()).thenReturn(Collections.singletonList(rating));
        List<Rating> ratingList = ratingS.getRatings();
        assertEquals(Collections.singletonList(rating), ratingList);
    }

    @Test
    void deleteRating() {
        ratingS.deleteRating(1);
        verify(ratingR, times(1)).delete(rating);
    }
}