package com.crud.crypto.repository.service;

import com.crud.crypto.domain.Coin;
import com.crud.crypto.domain.Wallet;
import com.crud.crypto.repository.CoinRepository;
import com.crud.crypto.repository.WalletRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WalletDbService {

    @Autowired
    private final WalletRepository repository;

    public Wallet getWallet() {
        return repository.findWalletBy();
    }

}
