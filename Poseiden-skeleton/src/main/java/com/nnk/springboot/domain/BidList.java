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
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "bidlist")
@Getter @Setter @NoArgsConstructor
public class BidList {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer bidListId;

    @NotBlank(message = "Account is mandatory")
    private String account;

    @NotBlank(message = "Type is mandatory")
    private String type;

    @Digits(integer = Digit.ENTIER, fraction = 2)
    private Double bidQuantity;

    //@Digits(integer = Digit.Entier, fraction = 2)
    private Double askQuantity;

    //@Digits(integer = Digit.Entier, fraction = 2)
    private Double bid;

    //@Digits(integer = Digit.Entier, fraction = 2)
    private Double ask;

    //@NotBlank(message = "Benchmark is mandatory")
    private String benchmark;

    private LocalDateTime bidListDate;

    //@NotBlank(message = "Commentary is mandatory")
    private String commentary;

    //@NotBlank(message = "Security is mandatory")
    private String security;

    //@NotBlank(message = "Status is mandatory")
    private String status;

    //@NotBlank(message = "Trader is mandatory")
    private String trader;

    //@NotBlank(message = "Book is mandatory")
    private String book;

    //@NotBlank(message = "CreationName is mandatory")
    private String creationName;

    private LocalDateTime creationDate;

    //@NotBlank(message = "RevisionName is mandatory")
    private String revisionName;

    private LocalDateTime revisionDate;

    //@NotBlank(message = "DealName is mandatory")
    private String dealName;

    //@NotBlank(message = "DealType is mandatory")
    private String dealType;

    //@NotBlank(message = "SourceListId is mandatory")
    private String sourceListId;

    //@NotBlank(message = "Side is mandatory")
    private String side;

    public BidList(final String accountC, final String typeC,
                   final Double bidQuantityC) {
        this.account = accountC;
        this.type = typeC;
        this.bidQuantity = bidQuantityC;
    }

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

    @Override
    public int hashCode() {
        return Objects.hash(getBidListId());
    }
}
