package com.nnk.springboot.service;

import com.nnk.springboot.domain.Rating;
import com.nnk.springboot.repositories.RatingRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingService implements RatingI {

    /**
     * Instantiation of LOGGER in order to inform in console.
     */
    private static final Logger LOGGER
            = LoggerFactory.getLogger(RatingService.class);

    /**
     * Instantiation of ratingRepository.
     */
    @Autowired
    private RatingRepository ratingR;

    //Service

    /**
     * Add / Update a rating in the database.
     * @param rating : to add / update.
     */
    @Override
    public void postRating(final Rating rating) {
        ratingR.save(rating);
        LOGGER.debug("Rating save");
    }

    /**
     * Find the rating which has the given id.
     * @param id : to find.
     * @return the rating.
     */
    @Override
    public Rating getRating(final int id) {
        LOGGER.debug("Rating found");
        return ratingR.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Invalid rating Id:" + id));
    }

    /**
     * Find all ratings.
     * @return the list of ratings.
     */
    @Override
    public List<Rating> getRatings() {
        LOGGER.debug("Ratings found");
        return ratingR.findAll();
    }

    /**
     * Removes the rating which has the given id.
     * @param id : to delete.
     */
    @Override
    public void deleteRating(final int id) {
        Rating rating = getRating(id);
        ratingR.delete(rating);
        LOGGER.debug("Rating remove");
    }
}
