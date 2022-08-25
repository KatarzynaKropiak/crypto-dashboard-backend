package com.crud.crypto.repository.service;

import com.crud.crypto.client.CryptoClient;
import com.crud.crypto.domain.*;
import com.crud.crypto.mapper.CryptoMapper;
import com.crud.crypto.repository.AssetRepository;
import com.crud.crypto.repository.WalletRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Component
@RequiredArgsConstructor
public class CryptoService {
    private final CryptoClient cryptoClient;
    private final CoinDbService coinDbService;
    private final CryptoMapper cryptoMapper;

    public List<SimpleRate> getAllCoinsRates(String currency) {
        List<Coin> coins = coinDbService.getAllCoins();
        List<String> coinsIds = coins.stream()
                .map(coin -> coin.getId())
                .collect(Collectors.toList());
        List<SimpleRateDto> responseDto = coinsIds.stream()
                .map(coinId -> cryptoClient.getSimpleRate(coinId, currency))
                .collect(Collectors.toList());
        List<SimpleRate> response = cryptoMapper.mapToSimpleRateList(responseDto);
        return response;

    }


}
