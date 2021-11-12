package com.nnk.springboot.domain;

import com.nnk.springboot.constants.Digit;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
@Getter @Setter @NoArgsConstructor
public class Rating {

    /**
     * Attribute id corresponding to id generate.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    /**
     * Attribute moodysRating corresponding to moodysRating choice.
     */
    @NotBlank(message = "MoodysRating is mandatory")
    private String moodysRating;

    /**
     * Attribute sandPRating corresponding to sandPRating choice.
     */
    @NotBlank(message = "SandPRating is mandatory")
    private String sandPRating;

    /**
     * Attribute fitchRating corresponding to fitchRating choice.
     */
    @NotBlank(message = "FitchRating is mandatory")
    private String fitchRating;

    /**
     * Attribute orderNumber corresponding to orderNumber choice.
     */
    @NotNull
    @Digits(integer = Digit.ENTIER, fraction = 0)
    private Integer orderNumber;

    /**
     * Test constructor.
     * @param moodysRatingC attribute.
     * @param sandPRatingC attribute.
     * @param fitchRatingC attribute.
     * @param orderNumberC attribute.
     */
    public Rating(final String moodysRatingC, final String sandPRatingC,
                  final String fitchRatingC, final Integer orderNumberC) {
        this.moodysRating = moodysRatingC;
        this.sandPRating = sandPRatingC;
        this.fitchRating = fitchRatingC;
        this.orderNumber = orderNumberC;
    }

    /**
     * ToString method.
     * @return toString.
     */
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

    /**
     * Equals method.
     * @param o : element to compare.
     * @return result of the comparison.
     */
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

    /**
     * HashCode method.
     * @return hashCode.
     */
    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
