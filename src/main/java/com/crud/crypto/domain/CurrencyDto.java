package com.crud.crypto.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CurrencyDto {
    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;

}
