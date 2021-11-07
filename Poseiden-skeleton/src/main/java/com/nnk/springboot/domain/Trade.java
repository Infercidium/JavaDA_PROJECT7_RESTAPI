package com.nnk.springboot.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.Objects;


@Entity
@Table(name = "trade")
@Setter @NoArgsConstructor @AllArgsConstructor
public class Trade {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer tradeId;

    @NotBlank(message = "Account is mandatory")
    private String account;

    @NotBlank(message = "Type is mandatory")
    private String type;

    private Double buyQuantity;

    private Double sellQuantity;

    private Double buyPrice;

    private Double sellPrice;

    @NotBlank(message = "Benchmark is mandatory")
    private String benchmark;

    private LocalDateTime tradeDate = LocalDateTime.now();

    @NotBlank(message = "Security is mandatory")
    private String security;

    @NotBlank(message = "Status is mandatory")
    private String status;

    @NotBlank(message = "Trader is mandatory")
    private String trader;

    @NotBlank(message = "Book is mandatory")
    private String book;

    @NotBlank(message = "CreationName is mandatory")
    private String creationName;

    private LocalDateTime creationDate = LocalDateTime.now();

    @NotBlank(message = "RevisionName is mandatory")
    private String revisionName;

    private LocalDateTime revisionDate = LocalDateTime.now();

    @NotBlank(message = "DealName is mandatory")
    private String dealName;

    @NotBlank(message = "DealType is mandatory")
    private String dealType;

    @NotBlank(message = "SourceListId is mandatory")
    private String sourceListId;

    @NotBlank(message = "Side is mandatory")
    private String side;

    public Trade(final String accountC, final String typeC) {
        this.account = accountC;
        this.type = typeC;
    }

    public Integer getTradeId() {
        return tradeId;
    }

    public String getAccount() {
        return account;
    }

    public String getType() {
        return type;
    }

    public Double getBuyQuantity() {
        return buyQuantity;
    }

    public Double getSellQuantity() {
        return sellQuantity;
    }

    public Double getBuyPrice() {
        return buyPrice;
    }

    public Double getSellPrice() {
        return sellPrice;
    }

    public String getBenchmark() {
        return benchmark;
    }

    public LocalDateTime getTradeDate() {
        return tradeDate;
    }

    public String getSecurity() {
        return security;
    }

    public String getStatus() {
        return status;
    }

    public String getTrader() {
        return trader;
    }

    public String getBook() {
        return book;
    }

    public String getCreationName() {
        return creationName;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public String getRevisionName() {
        return revisionName;
    }

    public LocalDateTime getRevisionDate() {
        return revisionDate;
    }

    public String getDealName() {
        return dealName;
    }

    public String getDealType() {
        return dealType;
    }

    public String getSourceListId() {
        return sourceListId;
    }

    public String getSide() {
        return side;
    }

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

    @Override
    public int hashCode() {
        return Objects.hash(getTradeId());
    }

}
