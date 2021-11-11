package com.nnk.springboot.domain;

import com.nnk.springboot.constants.Digit;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name = "rating")
public class Rating {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @NotBlank(message = "MoodysRating is mandatory")
    private String moodysRating;

    @NotBlank(message = "SandPRating is mandatory")
    private String sandPRating;

    @NotBlank(message = "FitchRating is mandatory")
    private String fitchRating;

    @NotNull
    @Digits(integer = Digit.Entier, fraction = 0)
    private Integer orderNumber;

    public Rating() {
    }

    public Rating(final String moodysRatingC, final String sandPRatingC, final String fitchRatingC, final Integer orderNumberC) {
        this.moodysRating = moodysRatingC;
        this.sandPRating = sandPRatingC;
        this.fitchRating = fitchRatingC;
        this.orderNumber = orderNumberC;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMoodysRating() {
        return moodysRating;
    }

    public void setMoodysRating(String moodysRating) {
        this.moodysRating = moodysRating;
    }

    public String getSandPRating() {
        return sandPRating;
    }

    public void setSandPRating(String sandPRating) {
        this.sandPRating = sandPRating;
    }

    public String getFitchRating() {
        return fitchRating;
    }

    public void setFitchRating(String fitchRating) {
        this.fitchRating = fitchRating;
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    @Override
    public String toString() {
        return "Rating{"
                + "id = " + id
                + ", moodysRating = '" + moodysRating + '\''
                + ", sandPRating = '" + sandPRating + '\''
                + ", fitchRating = '" + fitchRating + '\''
                + ", orderNumber = " + orderNumber
                + '}';
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Rating)) {
            return false;
        }
        Rating rating = (Rating) o;
        return getId().equals(rating.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
