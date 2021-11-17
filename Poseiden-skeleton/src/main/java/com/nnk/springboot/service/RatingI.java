package com.nnk.springboot.service;

import com.nnk.springboot.domain.Rating;

import java.util.List;

public interface RatingI {
    //Service
    /**
     * Add / Update a rating in the database.
     * @param rating : to add / update.
     */
    void postRating(Rating rating);

    /**
     * Update a rating in the database.
     * @param rating : to update.
     * @param id : to set id.
     */
    void updateRating(Rating rating, Integer id);

    /**
     * Find the rating which has the given id.
     * @param id : to find.
     * @return the rating.
     */
    Rating getRating(int id);

    /**
     * Find all ratings.
     * @return the list of ratings.
     */
    List<Rating> getRatings();

    /**
     * Removes the rating which has the given id.
     * @param id : to delete.
     */
    void deleteRating(int id);
}
