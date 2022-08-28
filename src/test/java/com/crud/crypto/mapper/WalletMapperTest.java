package com.crud.crypto.mapper;

import com.crud.crypto.domain.Coin;
import com.crud.crypto.domain.CoinDto;
import com.crud.crypto.domain.Wallet;
import com.crud.crypto.domain.WalletDto;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WalletMapperTest {

    private WalletMapper mapper = new WalletMapper();

    @Test
    void mapToWalletDto() {
        //Given
        Wallet wallet = new Wallet(1L, "name", "email");
        //When
        WalletDto testWallet = mapper.mapToWalletDto(wallet);
        //Then
        assertEquals(wallet.getWalletId(), testWallet.getWalletId());
        assertEquals(wallet.getUserName(), testWallet.getUserName());
        assertEquals(wallet.getEmail(), testWallet.getEmail());
    }

    @Test
    void mapToWallet() {
        //Given
        WalletDto walletDto = new WalletDto(1L, "name", "email");
        //When
        Wallet testWallet = mapper.mapToWallet(walletDto);
        //Then
        assertEquals(walletDto.getWalletId(), testWallet.getWalletId());
        assertEquals(walletDto.getUserName(), testWallet.getUserName());
        assertEquals(walletDto.getEmail(), testWallet.getEmail());
    }

    @Test
    void mapToWalletDtoList() {
        //Given
        List<Wallet> walletList = new ArrayList<>();
        Wallet wallet = new Wallet(1L, "name", "email");
        walletList.add(wallet);
        //When
        List<WalletDto> walletDtos = mapper.mapToWalletDtoList(walletList);
        //Then
        assertEquals(walletList.get(0).getWalletId(), walletDtos.get(0).getWalletId());
        assertEquals(walletList.get(0).getUserName(), walletDtos.get(0).getUserName());
        assertEquals(walletList.get(0).getEmail(), walletDtos.get(0).getEmail());
    }
}