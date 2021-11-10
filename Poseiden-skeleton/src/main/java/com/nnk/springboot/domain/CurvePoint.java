package com.nnk.springboot.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import java.time.LocalDateTime;
import java.util.Objects;


@Entity
@Table(name = "curvepoint")
@Data @Setter @NoArgsConstructor @AllArgsConstructor
public class CurvePoint {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @Digits(integer = 10, fraction = 0)
    private Integer curveId;

    private LocalDateTime asOfDate;

    @Digits(integer = 10, fraction = 2)
    private Double term;

    @Digits(integer = 10, fraction = 2)
    private Double value;

    private LocalDateTime creationDate;

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
