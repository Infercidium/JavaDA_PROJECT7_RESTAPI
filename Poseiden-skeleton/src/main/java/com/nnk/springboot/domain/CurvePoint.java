package com.nnk.springboot.domain;

import com.nnk.springboot.constants.Digit;

import javax.persistence.Entity;
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
public class CurvePoint {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    @Digits(integer = Digit.Entier, fraction = 0)
    private Integer curveId;

    private LocalDateTime asOfDate;

    @Digits(integer = Digit.Entier, fraction = 2)
    private Double term;

    @Digits(integer = Digit.Entier, fraction = 2)
    private Double value;

    private LocalDateTime creationDate;

    public CurvePoint() {
    }

    public CurvePoint(final Integer curveIdC, final Double termC, final Double valueC) {
        this.curveId = curveIdC;
        this.term = termC;
        this.value = valueC;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCurveId() {
        return curveId;
    }

    public void setCurveId(Integer curveId) {
        this.curveId = curveId;
    }

    public LocalDateTime getAsOfDate() {
        return asOfDate;
    }

    public void setAsOfDate(LocalDateTime asOfDate) {
        this.asOfDate = asOfDate;
    }

    public Double getTerm() {
        return term;
    }

    public void setTerm(Double term) {
        this.term = term;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

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

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
