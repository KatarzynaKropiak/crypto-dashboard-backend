package com.crud.crypto.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class WalletDto {

    @JsonProperty("walletId")
    private Long walletId;

    @JsonProperty("userName")
    private String userName;

    @JsonProperty("email")
    private String email;

    public Long getWalletId() {
        return walletId;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }
}
