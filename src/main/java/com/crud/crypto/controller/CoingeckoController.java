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