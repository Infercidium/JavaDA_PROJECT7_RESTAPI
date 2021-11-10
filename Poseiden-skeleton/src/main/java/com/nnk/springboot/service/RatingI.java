package com.nnk.springboot.service;

import com.nnk.springboot.domain.Rating;

import java.util.List;

public interface RatingI {
    //Service
    void postRating(Rating rating);

    Rating getRating(int id);

    List<Rating> getRatings();

    void deleteRating(int id);
}
