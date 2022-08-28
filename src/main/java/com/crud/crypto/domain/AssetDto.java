package com.crud.crypto.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
public class AssetDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("walletId")
    private Long walletId;

    @JsonProperty("coinId")
    private String coinId;

    @JsonProperty("coinValue")
    private BigDecimal coinValue;

    @JsonProperty("currencyId")
    private String currencyId;

    @JsonProperty("currencyValue")
    private BigDecimal currencyValue;

    public AssetDto(Long walletId, String coinId, BigDecimal coinValue, String currencyId, BigDecimal currencyValue) {
        this.walletId = walletId;
        this.coinId = coinId;
        this.coinValue = coinValue;
        this.currencyId = currencyId;
        this.currencyValue = currencyValue;
    }

}
