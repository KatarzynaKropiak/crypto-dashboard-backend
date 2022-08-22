package com.crud.crypto.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AssetsDto {

    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("walletId")
    private String walletID;

    @JsonProperty("coinId")
    private String coinId;

    @JsonProperty("coinValue")
    private String coinValue;

    @JsonProperty("currencyId")
    private String currencyId;

    @JsonProperty("currencyValue")
    private String currencyValue;
}
