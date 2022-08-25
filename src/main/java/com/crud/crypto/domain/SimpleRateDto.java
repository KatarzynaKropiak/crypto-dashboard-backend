package com.crud.crypto.domain;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRawValue;
import lombok.Data;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class SimpleRateDto {

    private String coinId;
    private String currency;
    private BigDecimal rate;

    public SimpleRateDto(String coinId, String currency, BigDecimal rate) {
        this.coinId = coinId;
        this.currency = currency;
        this.rate = rate;
    }

    private Map<String, Object> details = new LinkedHashMap<>();

    @JsonAnySetter
    void setDetail(String key, Object value) {
        details.put(key, value);
        this.coinId = (String) details.keySet().toArray()[0];
        System.out.println("coinId: " + this.coinId);
        this.currency = (String) ((Map) details.get(this.coinId)).keySet().toArray()[0];
        System.out.println("currency: " + this.currency);
        this.rate = new BigDecimal(((Map) details.get(this.coinId)).values().toArray()[0].toString());
        details = null;
    }

}
