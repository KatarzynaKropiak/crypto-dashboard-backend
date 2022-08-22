package com.crud.crypto.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Entity(name = "assets")
public class Asset {

    @javax.persistence.Id
    @GeneratedValue
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "walletId")
    private String WalletId;

    @Column(name = "coinId")
    private String coinId;

    @Column(name = "coinValue")
    private String coinValue;

    @Column(name = "currencyId")
    private String currencyId;

    @Column(name = "currencyValue")
    private String currencyValue;
}