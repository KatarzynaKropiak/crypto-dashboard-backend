package com.crud.crypto.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

    @NoArgsConstructor
    @Getter
    @Setter
    @Entity(name = "wallets")
    public class Wallet {

        @javax.persistence.Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE)
        @Id
        @NotNull
        @Setter
        @Column(name = "walletId")
        private Long walletId;

        @Column(name = "userName")
        private String userName;

        @NotNull
        @Column(name = "email")
        private String email;

        @OneToMany(
            targetEntity = Asset.class,
            mappedBy = "wallet")
        private List<Asset> assets = new ArrayList<>();

    public Wallet(Long walletId, String userName, String email) {
        this.walletId = walletId;
        this.userName = userName;
        this.email = email;
    }

        public Wallet(Long walletID) {
            this.walletId = walletID;
        }

//    public void setId(Long walletId) {
//        this.walletId = walletId;
//    }
//
//    public Long getId() {
//        return walletId;
//    }
}
