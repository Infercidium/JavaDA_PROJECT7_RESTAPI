package com.nnk.springboot.domain;

import com.nnk.springboot.constants.Digit;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "bidlist")
@EntityListeners(AuditingEntityListener.class)
@Getter @Setter @NoArgsConstructor
public class BidList {

    /**
     * Attribute id corresponding to id generate.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bidListId;

    /**
     * Attribute account corresponding to account choice.
     */
    @NotBlank(message = "Account is mandatory")
    private String account;

    /**
     * Attribute type corresponding to type choice.
     */
    @NotBlank(message = "Type is mandatory")
    private String type;

    /**
     * Attribute bidQuantity corresponding to bidQuantity choice.
     */
    @Digits(integer = Digit.ENTIER, fraction = 2)
    private Double bidQuantity;

    /**
     * Not use.
     */
    private Double askQuantity;

    /**
     * Not use.
     */
    private Double bid;

    /**
     * Not use.
     */
    private Double ask;

    /**
     * Not use.
     */
    private String benchmark;

    /**
     * Not use.
     */
    private LocalDateTime bidListDate;

    /**
     * Not use.
     */
    private String commentary;

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
     * Attribute creationName is User creator.
     */
    @CreatedBy
    private String creationName;

    /**
     * Attribute creationDate corresponding to creationDate of Bid.
     */
    @CreatedDate
    private LocalDateTime creationDate;

    /**
     * Attribute revisionName is last User to have modified it.
     */
    @LastModifiedBy
    private String revisionName;

    /**
     * Attribute revisionDate corresponding to last update date Bid.
     */
    @LastModifiedDate
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
     * Test Constructor.
     * @param accountC attribute.
     * @param typeC attribute.
     * @param bidQuantityC attribute.
     */
    public BidList(final String accountC, final String typeC,
                   final Double bidQuantityC) {
        this.account = accountC;
        this.type = typeC;
        this.bidQuantity = bidQuantityC;
    }

    /**
     * ToString method.
     * @return toString.
     */
    @Override
    public String toString() {
        return "BidList{"
                + "bidListId = " + bidListId
                + ", account = '" + account + '\''
                + ", type = '" + type + '\''
                + ", bidQuantity = " + bidQuantity
                + ", askQuantity = " + askQuantity
                + ", bid = " + bid
                + ", ask = " + ask
                + ", benchmark = '" + benchmark + '\''
                + ", bidListDate = " + bidListDate
                + ", commentary = '" + commentary + '\''
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
        if (!(o instanceof BidList)) {
            return false;
        }
        BidList bidList = (BidList) o;
        return getBidListId().equals(bidList.getBidListId());
    }

    /**
     * HashCode method.
     * @return hashCode.
     */
    @Override
    public int hashCode() {
        return Objects.hash(getBidListId());
    }
}
