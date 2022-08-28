package com.crud.crypto.repository.service;

import com.crud.crypto.domain.Wallet;
import com.crud.crypto.exception.WalletNotFoundException;
import com.crud.crypto.repository.WalletRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest

class WalletDbServiceTest {

    @Autowired
    private WalletRepository walletRepository;

    @Autowired
    private WalletDbService service;

    @Test
    void getAllWallets() {
        //Given
        walletRepository.deleteAll();
        Wallet wallet = new Wallet();
        wallet.setEmail("user@mail.com");
        walletRepository.save(wallet);
        //When
        List<Wallet> wallets = service.getAllWallets();
        //Then
        assertEquals(1, wallets.size());
        //CleanUp
        walletRepository.deleteAll();
    }

    @Test
    void saveWallet() {
        //Given
        service.deleteAllWallets();
        Wallet wallet = new Wallet();
        wallet.setWalletId(1L);
        wallet.setEmail("test@mail.com");
        service.saveWallet(wallet);
        //When
        List<Wallet> wallets = service.getAllWallets();
        //Then
        assertEquals(1, wallets.size());
        //CleanUp
        walletRepository.deleteAll();
    }

    @Test
    void deleteById() {
        //Given
        walletRepository.deleteAll();
        Wallet wallet = new Wallet();
        wallet.setEmail("test@mail.com");
        walletRepository.save(wallet);
        walletRepository.deleteById(wallet.getWalletId());

        //When
        List<Wallet> wallets = service.getAllWallets();
        //Then
        assertTrue(wallets.isEmpty());
        //CleanUp
        walletRepository.deleteAll();
    }
    @Test
    void getWalletById() throws WalletNotFoundException {
        //Given
        walletRepository.deleteAll();
        Wallet wallet = new Wallet();
        wallet.setEmail("test@mail.com");
        walletRepository.save(wallet);
        service.getWalletById(wallet.getWalletId());

        //Then
        assertEquals(wallet.getEmail(), service.getWalletById(wallet.getWalletId()).getEmail());
        //CleanUp
        walletRepository.deleteAll();
    }
    @Test
    void deleteAllWallets() {
        service.deleteAllWallets();
        assertTrue(walletRepository.findAll().isEmpty());
    }

}