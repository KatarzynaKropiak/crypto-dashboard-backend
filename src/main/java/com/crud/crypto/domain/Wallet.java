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
    @Entity(name = "wallets")
    public class Wallet {

        @javax.persistence.Id
        @GeneratedValue
        @Id
        @Column(name = "userId")
        private String userId;

        @Column(name = "name")
        private String name;

        @Column(name = "email")
        private String email;
}
