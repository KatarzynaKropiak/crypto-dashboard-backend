package com.crud.crypto.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;

public class WalletDto {

    @JsonProperty("userId")
    private String userId;

    @JsonProperty("name")
    private String name;

    @JsonProperty("email")
    private String email;
}
