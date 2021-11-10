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
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.Objects;


@Entity
@Table(name = "trade")
@Data @Setter @NoArgsConstructor @AllArgsConstructor
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

    public void setTradeId(Integer tradeId) {
        this.tradeId = tradeId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getBuyQuantity() {
        return buyQuantity;
    }

    public void setBuyQuantity(Double buyQuantity) {
        this.buyQuantity = buyQuantity;
    }

    public Double getSellQuantity() {
        return sellQuantity;
    }

    public void setSellQuantity(Double sellQuantity) {
        this.sellQuantity = sellQuantity;
    }

    public Double getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(Double buyPrice) {
        this.buyPrice = buyPrice;
    }

    public Double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(Double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public String getBenchmark() {
        return benchmark;
    }

    public void setBenchmark(String benchmark) {
        this.benchmark = benchmark;
    }

    public LocalDateTime getTradeDate() {
        return tradeDate;
    }

    public void setTradeDate(LocalDateTime tradeDate) {
        this.tradeDate = tradeDate;
    }

    public String getSecurity() {
        return security;
    }

    public void setSecurity(String security) {
        this.security = security;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTrader() {
        return trader;
    }

    public void setTrader(String trader) {
        this.trader = trader;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public String getCreationName() {
        return creationName;
    }

    public void setCreationName(String creationName) {
        this.creationName = creationName;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public String getRevisionName() {
        return revisionName;
    }

    public void setRevisionName(String revisionName) {
        this.revisionName = revisionName;
    }

    public LocalDateTime getRevisionDate() {
        return revisionDate;
    }

    public void setRevisionDate(LocalDateTime revisionDate) {
        this.revisionDate = revisionDate;
    }

    public String getDealName() {
        return dealName;
    }

    public void setDealName(String dealName) {
        this.dealName = dealName;
    }

    public String getDealType() {
        return dealType;
    }

    public void setDealType(String dealType) {
        this.dealType = dealType;
    }

    public String getSourceListId() {
        return sourceListId;
    }

    public void setSourceListId(String sourceListId) {
        this.sourceListId = sourceListId;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
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
