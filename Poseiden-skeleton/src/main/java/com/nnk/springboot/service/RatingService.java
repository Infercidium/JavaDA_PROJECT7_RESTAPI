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

    private static final Logger LOGGER = LoggerFactory.getLogger(RatingService.class);

    @Autowired
    private RatingRepository ratingR;

    //Service
    @Override
    public void postRating(final Rating rating) {
        ratingR.save(rating);
        LOGGER.debug("Rating save");
    }

    @Override
    public Rating getRating(final int id) {
        LOGGER.debug("Rating found");
        return ratingR.getOne(id);
    }

    @Override
    public List<Rating> getRatings() {
        LOGGER.debug("Ratings found");
        return ratingR.findAll();
    }

    @Override
    public void deleteRating(final int id) {
        Rating rating = getRating(id);
        ratingR.delete(rating);
        LOGGER.debug("Rating remove");
    }
}
