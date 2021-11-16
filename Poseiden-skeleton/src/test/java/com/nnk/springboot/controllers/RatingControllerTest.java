package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.Rating;
import com.nnk.springboot.service.RatingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.isA;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = {RatingController.class})
class RatingControllerTest {

    @MockBean
    private RatingService ratingS;

    @MockBean
    private Model model;

    @MockBean
    private BindingResult result;

    @Autowired
    private RatingController ratingC;

    private final Rating rating = new Rating("moody", "sand", "fitch", 1);

    @BeforeEach
    void setUp() {
        when(ratingS.getRating(isA(Integer.class))).thenReturn(rating);
    }

    @Test
    void home() {
        String result1 = ratingC.home(model);
        assertEquals("rating/list", result1);
    }

    @Test
    void addRatingForm() {
        String result2 = ratingC.addRatingForm(rating);
        assertEquals("rating/add", result2);
    }

    @Test
    void validate() {
        when(result.hasErrors()).thenReturn(false);
        String result3 = ratingC.validate(rating, result, model);
        assertEquals("redirect:/rating/list", result3);
    }

    @Test
    void validateFail() {
        when(result.hasErrors()).thenReturn(true);
        String result32 = ratingC.validate(rating, result, model);
        assertEquals("rating/add", result32);
    }

    @Test
    void showUpdateForm() {
        String result4 = ratingC.showUpdateForm(isA(Integer.class), model);
        assertEquals("rating/update", result4);
    }

    @Test
    void updateRating() {
        when(result.hasErrors()).thenReturn(false);
        String result5 = ratingC.updateRating(1, rating, result, model);
        assertEquals("redirect:/rating/list", result5);
    }

    @Test
    void updateRatingFail() {
        when(result.hasErrors()).thenReturn(true);
        String result52 = ratingC.updateRating(1, rating, result, model);
        assertEquals("rating/update", result52);
    }

    @Test
    void deleteRating() {
        String result6 = ratingC.deleteRating(isA(Integer.class), model);
        assertEquals("redirect:/rating/list", result6);
    }
}