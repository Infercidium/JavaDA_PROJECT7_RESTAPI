package com.nnk.springboot.domain;

import com.nnk.springboot.constants.Digit;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.Objects;


@Entity
@Table(name = "trade")
@Getter @Setter
public class Trade {

    /**
     * Attribute id corresponding to id generate.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer tradeId;

    /**
     * Attribute CurveId corresponding to CurveId choice.
     */
    @NotBlank(message = "Account is mandatory")
    private String account;

    /**
     * Attribute CurveId corresponding to CurveId choice.
     */
    @NotBlank(message = "Type is mandatory")
    private String type;

    /**
     * Attribute CurveId corresponding to CurveId choice.
     */
    @Digits(integer = Digit.ENTIER, fraction = 2)
    private Double buyQuantity;

    /**
     * Not use.
     */
    private Double sellQuantity;

    /**
     * Not use.
     */
    private Double buyPrice;

    /**
     * Not use.
     */
    private Double sellPrice;

    /**
     * Not use.
     */
    private String benchmark;

    /**
     * Not use.
     */
    private LocalDateTime tradeDate;

    /**
     * Not use.
     */
    private String security;

    /**
     * Not use.
     */
    private String status;

    /**
     * Not use.
     */
    private String trader;

    /**
     * Not use.
     */
    private String book;

    /**
     * Not use.
     */
    private String creationName;

    /**
     * Attribute creationDate corresponding to creationDate of Trade.
     */
    private LocalDateTime creationDate;

    /**
     * Not use.
     */
    private String revisionName;

    /**
     * Attribute revisionDate corresponding to last update date Trade.
     */
    private LocalDateTime revisionDate;

    /**
     * Not use.
     */
    private String dealName;

    /**
     * Not use.
     */
    private String dealType;

    /**
     * Not use.
     */
    private String sourceListId;

    /**
     * Not use.
     */
    private String side;

    /**
     * Basic constructor.
     */
    public Trade() {
        if (creationDate == null) {
            creationDate = LocalDateTime.now();
        } else {
            revisionDate = LocalDateTime.now();
        }
    }

    /**
     * Test constructor.
     * @param accountC attribute.
     * @param typeC attribute.
     */
    public Trade(final String accountC, final String typeC) {
        this.account = accountC;
        this.type = typeC;
    }

    /**
     * ToString method.
     * @return toString.
     */
    @Override
    public String toString() {
        return "Trade{"
                + "tradeId = " + tradeId
                + ", account = '" + account + '\''
                + ", type = '" + type + '\''
                + ", buyQuantity = " + buyQuantity
                + ", sellQuantity = " + sellQuantity
                + ", buyPrice = " + buyPrice
                + ", sellPrice = " + sellPrice
                + ", benchmark = '" + benchmark + '\''
                + ", tradeDate = " + tradeDate
                + ", security = '" + security + '\''
                + ", status = '" + status + '\''
                + ", trader = '" + trader + '\''
                + ", book = '" + book + '\''
                + ", creationName = '" + creationName + '\''
                + ", creationDate = " + creationDate
                + ", revisionName = '" + revisionName + '\''
                + ", revisionDate = " + revisionDate
                + ", dealName = '" + dealName + '\''
                + ", dealType = '" + dealType + '\''
                + ", sourceListId = '" + sourceListId + '\''
                + ", side = '" + side + '\''
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
        if (!(o instanceof Trade)) {
            return false;
        }
        Trade trade = (Trade) o;
        return getTradeId().equals(trade.getTradeId());
    }

    /**
     * HashCode method.
     * @return hashCode.
     */
    @Override
    public int hashCode() {
        return Objects.hash(getTradeId());
    }
}
