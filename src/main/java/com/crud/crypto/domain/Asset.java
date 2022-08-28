package com.crud.crypto.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@NoArgsConstructor
@Getter
@AllArgsConstructor
@Entity(name = "assets")
public class Asset {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "walletId", referencedColumnName = "walletId")
    private Wallet wallet;

    @Column(name = "coinId")
    private String coinId;

    @Column(name = "coinValue")
    private BigDecimal coinValue;

    @Column(name = "currencyId")
    private String currencyId;

    @Column(name = "currencyValue")
    private BigDecimal currencyValue;

    public Asset(Wallet wallet, String coinId, BigDecimal coinValue, String currencyId, BigDecimal currencyValue) {
        this.wallet = wallet;
        this.coinId = coinId;
        this.coinValue = coinValue;
        this.currencyId = currencyId;
        this.currencyValue = currencyValue;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
