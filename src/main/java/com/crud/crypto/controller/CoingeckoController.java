package com.crud.crypto.controller;

import com.crud.crypto.client.CryptoClient;
import com.crud.crypto.domain.*;
import com.crud.crypto.mapper.CoinMapper;
import com.crud.crypto.mapper.CurrencyMapper;
import com.crud.crypto.repository.service.CoinDbService;
import com.crud.crypto.repository.service.CurrencyDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("v1/crypto")
@RequiredArgsConstructor
@CrossOrigin("*")
public class CoingeckoController {

    private final CryptoClient cryptoClient;
    private final CoinMapper coinMapper;
    private final CoinDbService coinDbService;
    private final CurrencyMapper currencyMapper;
    private final CurrencyDbService currencyDbService;

    @GetMapping("simpleRate")
    public ResponseEntity <SimpleRateDto> getSimpleRate(@RequestParam String coinId, @RequestParam String currency) {
            return ResponseEntity.ok(cryptoClient.getSimpleRate(coinId, currency));
    }

    @GetMapping("allRates")
    public ResponseEntity <List<SimpleRateDto>> getAllRates(@RequestParam String currency) {
        List<Coin> coins = coinDbService.getAllCoins();
        List<String> coinsIds = coins.stream()
                .map(coin -> coin.getId())
                .collect(Collectors.toList());
        List<SimpleRateDto> response = coinsIds.stream()
                .map(coinId -> cryptoClient.getSimpleRate(coinId, currency))
                .collect(Collectors.toList());

        return ResponseEntity.ok(response);    }

    @GetMapping("allCurrencies")
    public ResponseEntity <List<SimpleRateDto>> getAllCurrencies(@RequestParam String coinId) {
        List<Currency> currencies = currencyDbService.getAllCurrencies();
        List<String> curenciesIds = currencies.stream()
                .map(currency -> currency.getId())
                .collect(Collectors.toList());
        List<SimpleRateDto> response = curenciesIds.stream()
                .map(currenciesId -> cryptoClient.getSimpleRate(coinId, currenciesId))
                .collect(Collectors.toList());

        return ResponseEntity.ok(response);    }


    @GetMapping("coinList")
    public ResponseEntity <List<CoinDto>> getCoinsList() {
        return ResponseEntity.ok(cryptoClient.getCoinsList());
    }


    @GetMapping("coins")
    public ResponseEntity<List<CoinDto>> getCoins() {
            List<Coin> coins = coinDbService.getAllCoins();
            return ResponseEntity.ok(coinMapper.mapToCoinDtoList(coins));
        }

    @GetMapping("currencies")
    public ResponseEntity<List<CurrencyDto>> getCurrencies() {
        List<Currency> currencies = currencyDbService.getAllCurrencies();
        return ResponseEntity.ok(currencyMapper.mapToCurrencyDtoList(currencies));
    }

    }