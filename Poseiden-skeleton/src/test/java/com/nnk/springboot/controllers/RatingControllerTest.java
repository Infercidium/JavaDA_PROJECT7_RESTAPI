package com.nnk.springboot.controllers;

import com.nnk.springboot.service.RatingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.isA;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = {RatingController.class})
class RatingControllerTest {

    @MockBean
    private RatingService ratingS;

    @Autowired
    private RatingController ratingC;

    @BeforeEach
    void setUp() {

    }

    @Test
    void home() {
    }

    @Test
    void addRatingForm() {
    }

    @Test
    void validate() {
    }

    @Test
    void showUpdateForm() {
    }

    @Test
    void updateRating() {
    }

    @Test
    void deleteRating() {
    }
}