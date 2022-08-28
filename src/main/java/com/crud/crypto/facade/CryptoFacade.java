package com.crud.crypto.facade;

import com.crud.crypto.client.CryptoClient;
import com.crud.crypto.domain.Coin;
import com.crud.crypto.domain.Currency;
import com.crud.crypto.domain.SimpleRateDto;
import com.crud.crypto.mapper.SimpleRateMapper;
import com.crud.crypto.repository.service.CoinDbService;
import com.crud.crypto.repository.service.CurrencyDbService;
import com.crud.crypto.repository.service.SimpleRateDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CryptoFacade {

    private final CryptoClient cryptoClient;
    private final CoinDbService coinDbService;
    private final SimpleRateMapper simpleRateMapper;
    private final CurrencyDbService currencyDbService;
    private final SimpleRateDbService simpleRateDbService;

    public List<SimpleRateDto> getAllCoinsRates(String currency) {
        List<Coin> coins = coinDbService.getAllCoins();
        List<String> coinsIds = coins.stream()
                .map(coin -> coin.getId())
                .collect(Collectors.toList());
        List<SimpleRateDto> response = coinsIds.stream()
                .map(coinId -> cryptoClient.getSimpleRate(coinId, currency))
                .collect(Collectors.toList());

        LocalDateTime date = LocalDateTime.now();

        response.stream()
                .map(rate -> simpleRateMapper.mapToSimpleRate(rate))
                .peek(rate -> rate.setDate(date))
                .forEach(rate -> simpleRateDbService.saveSimpleRate(rate));
        return response;

    }

    public List<SimpleRateDto> getRateForAllCurrencies(String coinId) {
        List<Currency> currencies = currencyDbService.getAllCurrencies();
        List<String> currenciesIds = currencies.stream()
                .map(currency -> currency.getId())
                .collect(Collectors.toList());
        List<SimpleRateDto> response = currenciesIds.stream()
                .map(currenciesId -> cryptoClient.getSimpleRate(coinId, currenciesId))
                .collect(Collectors.toList());
        return response;
    }
}