package com.crud.crypto.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity(name = "simpleRate")
public class SimpleRate {
    @javax.persistence.Id
    @Id
    @NotNull
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String coinId;
    private String currency;
    private BigDecimal rate;
    private LocalDateTime date;

    public SimpleRate(String coinId, String currency, BigDecimal rate) {
        this.coinId = coinId;
        this.currency = currency;
        this.rate = rate;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
