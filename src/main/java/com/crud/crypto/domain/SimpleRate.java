package com.crud.crypto.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class SimpleRate {
    private String coinId;
    private String currency;
    private BigDecimal rate;
}
