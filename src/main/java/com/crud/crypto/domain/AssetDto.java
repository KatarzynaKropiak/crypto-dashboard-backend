package com.crud.crypto.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class AssetDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;

//    @JsonProperty("walletId")
//    private Long walletID;

    @JsonProperty("coinId")
    private String coinId;

    @JsonProperty("coinValue")
    private BigDecimal coinValue;

    @JsonProperty("currencyId")
    private String currencyId;

    @JsonProperty("currencyValue")
    private BigDecimal currencyValue;

    public AssetDto(Long id, String name, String coinId, BigDecimal coinValue, String currencyId, BigDecimal currencyValue) {
    }


}
