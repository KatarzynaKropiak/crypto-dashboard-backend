package com.crud.crypto.mapper;

import com.crud.crypto.domain.Coin;
import com.crud.crypto.domain.CoinDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CoinMapper {
    public CoinDto mapToCoinDto(final Coin coin) {
        return new CoinDto(
                coin.getId(),
                coin.getSymbol(),
                coin.getName()
        );
    }

    public Coin mapToCoin(final CoinDto coinDto) {
        return new Coin(
                coinDto.getId(),
                coinDto.getSymbol(),
                coinDto.getName()
        );
    }

    public List<CoinDto> mapToCoinDtoList(final List<Coin> coinList) {
        return coinList.stream()
                .map(this::mapToCoinDto)
                .collect(Collectors.toList());
    }
}
