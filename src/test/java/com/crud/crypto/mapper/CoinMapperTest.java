package com.crud.crypto.mapper;

import com.crud.crypto.domain.Coin;
import com.crud.crypto.domain.CoinDto;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CoinMapperTest {

    private CoinMapper coinMapper = new CoinMapper();


    @Test
    void mapToCoinDto() {
        //Given
        CoinDto coinDto = new CoinDto("id", "name", "symbol");
        //When
        Coin testCoin = coinMapper.mapToCoin(coinDto);
        //Then
        assertEquals(coinDto.getId(), testCoin.getId());
        assertEquals(coinDto.getName(), testCoin.getName());
        assertEquals(coinDto.getSymbol(), testCoin.getSymbol());
    }

    @Test
    void mapToCoin() {
        //Given
        Coin coin = new Coin("id", "name", "symbol");
        //When
        CoinDto testCoinDto = coinMapper.mapToCoinDto(coin);
        //Then
        assertEquals(coin.getId(), testCoinDto.getId());
        assertEquals(coin.getName(), testCoinDto.getName());
        assertEquals(coin.getSymbol(), testCoinDto.getSymbol());
    }

    @Test
    void mapToCoinDtoList() {
        //Given
        List<Coin> coinList = new ArrayList<>();
        Coin coin = new Coin("id", "name", "symbol");
        coinList.add(coin);
        //When
        List<CoinDto> coinDtos = coinMapper.mapToCoinDtoList(coinList);
        //Then
        assertEquals(coinList.get(0).getId(), coinDtos.get(0).getId());
        assertEquals(coinList.get(0).getName(), coinDtos.get(0).getName());
        assertEquals(coinList.get(0).getSymbol(), coinDtos.get(0).getSymbol());
    }
}