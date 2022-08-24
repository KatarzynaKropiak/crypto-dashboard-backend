package com.crud.crypto.repository.service;

import com.crud.crypto.domain.Asset;
import com.crud.crypto.domain.Coin;
import com.crud.crypto.domain.Wallet;
import com.crud.crypto.exception.AssetNotFoundException;
import com.crud.crypto.exception.WalletNotFoundException;
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

    public List<Wallet> getAllWallets() {
        return repository.findAll();
    }

    public Wallet getWalletById(final long walletId) throws WalletNotFoundException {
        return repository.findById(walletId).orElseThrow(WalletNotFoundException::new);
    }

    public Wallet saveWallet(final Wallet wallet) {
        return repository.save(wallet);
    }

    public void deleteWallet(final long walletId) {
        repository.deleteById(walletId);
    }

    public void deleteAllWallets() { repository.deleteAll(); }
}
