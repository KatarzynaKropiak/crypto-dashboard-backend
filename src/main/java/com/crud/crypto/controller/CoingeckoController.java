package com.crud.crypto.controller;

import com.crud.crypto.client.CryptoClient;
import com.crud.crypto.domain.*;
import com.crud.crypto.facade.CryptoFacade;
import com.crud.crypto.mapper.CoinMapper;
import com.crud.crypto.mapper.CurrencyMapper;
import com.crud.crypto.repository.service.AuditDbService;
import com.crud.crypto.repository.service.CoinDbService;
import com.crud.crypto.repository.service.CurrencyDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
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
    private final CryptoFacade cryptoFacade;
    private final AuditDbService auditDbService;

    @GetMapping(value = "rates", params = {"coinId", "currency"})
    public ResponseEntity <SimpleRateDto> getSimpleRate(@RequestParam String coinId, @RequestParam String currency) {
        SimpleRateDto response =  cryptoClient.getSimpleRate(coinId, currency);
        auditDbService.savelog(new AuditLog("getSimpleRate", LocalDateTime.now()));
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "rates", params = "currency")
    public ResponseEntity <List<SimpleRateDto>> getAllRates(@RequestParam String currency) {
        auditDbService.savelog(new AuditLog("getAllRates", LocalDateTime.now()));
        return ResponseEntity.ok(cryptoFacade.getAllCoinsRates(currency));    }

    @GetMapping(value = "rates", params = "coinId")
    public ResponseEntity <List<SimpleRateDto>> getRateForAllCurrencies(@RequestParam String coinId) {
        auditDbService.savelog(new AuditLog("getRateForAllCurrencies", LocalDateTime.now()));
        return ResponseEntity.ok(cryptoFacade.getRateForAllCurrencies(coinId));    }


    @GetMapping("coinsList")
    public ResponseEntity <List<CoinDto>> getCoinsList() {
        auditDbService.savelog(new AuditLog("getCoinsList", LocalDateTime.now()));

        return ResponseEntity.ok(cryptoClient.getCoinsList());
    }


    @GetMapping("coins")
    public ResponseEntity<List<CoinDto>> getCoins() {
        List<Coin> coins = coinDbService.getAllCoins();
        auditDbService.savelog(new AuditLog("getCoins", LocalDateTime.now()));

        return ResponseEntity.ok(coinMapper.mapToCoinDtoList(coins));
        }

    @GetMapping("currencies")
    public ResponseEntity<List<CurrencyDto>> getCurrencies() {
        List<Currency> currencies = currencyDbService.getAllCurrencies();
        auditDbService.savelog(new AuditLog("getCurrencies", LocalDateTime.now()));

        return ResponseEntity.ok(currencyMapper.mapToCurrencyDtoList(currencies));
    }

    }