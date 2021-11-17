package com.nnk.springboot.domain;

import com.nnk.springboot.constants.Digit;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Objects;


@Entity
@Table(name = "curvepoint")
@EntityListeners(AuditingEntityListener.class)
@Getter @Setter @NoArgsConstructor
public class CurvePoint {

    /**
     * Attribute id corresponding to id generate.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Attribute CurveId corresponding to CurveId choice.
     */
    @NotNull
    @Digits(integer = Digit.ENTIER, fraction = 0)
    private Integer curveId;

    /**
     * Attribute asOfDate corresponding to last update CurvePoint.
     */
    @LastModifiedDate
    private LocalDateTime asOfDate;

    /**
     * Attribute term corresponding to term choice.
     */
    @Digits(integer = Digit.ENTIER, fraction = 2)
    private Double term;

    /**
     * Attribute value corresponding to value choice.
     */
    @Digits(integer = Digit.ENTIER, fraction = 2)
    private Double value;

    /**
     * Attribute creationDate corresponding to creationDate of CurvePoint.
     */
    @CreatedDate
    private LocalDateTime creationDate;

    /**
     * Test constructor.
     * @param curveIdC attribute.
     * @param termC attribute.
     * @param valueC attribute.
     */
    public CurvePoint(final Integer curveIdC,
                      final Double termC, final Double valueC) {
        this.curveId = curveIdC;
        this.term = termC;
        this.value = valueC;
    }

    /**
     * ToString method.
     * @return toString.
     */
    @Override
    public String toString() {
        return "CurvePoint{"
                + "id = " + id
                + ", curveId = " + curveId
                + ", asOfDate = " + asOfDate
                + ", term = " + term
                + ", value = " + value
                + ", creationDate = " + creationDate
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
        if (!(o instanceof CurvePoint)) {
            return false;
        }
        CurvePoint that = (CurvePoint) o;
        return getId().equals(that.getId());
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
