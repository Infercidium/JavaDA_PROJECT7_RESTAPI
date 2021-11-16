package com.nnk.springboot.domain;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest(classes = {Rating.class})
class RatingTest {

    private final Rating rating = new Rating("moody", "sand", "fitch", 1);
    private final Rating rating1 = new Rating("moody", "sand", "fitch", 1);
    private final Rating rating2 = new Rating("moody", "sand", "fitch", 1);

    @Test
    void testToString() {
        assertEquals("Rating{id = null, moodysRating = 'moody', sandPRating = 'sand', fitchRating = 'fitch', orderNumber = 1}", rating.toString());
    }

    @Test
    void testEquals() {
        rating.setId(1);
        rating1.setId(1);
        rating2.setId(2);
        assertEquals(rating, rating1);
        assertNotEquals(rating, rating2);
    }
}