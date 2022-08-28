package com.crud.crypto.controller;

import com.crud.crypto.client.CryptoClient;
import com.crud.crypto.domain.*;
import com.crud.crypto.facade.CryptoFacade;
import com.crud.crypto.mapper.CoinMapper;
import com.crud.crypto.mapper.CurrencyMapper;
import com.crud.crypto.repository.service.AuditDbService;
import com.crud.crypto.repository.service.CoinDbService;
import com.crud.crypto.repository.service.CurrencyDbService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringJUnitWebConfig
@WebMvcTest(CoingeckoController.class)
@AutoConfigureMockMvc
class CoingeckoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CryptoFacade cryptoFacade;
    @MockBean
    private CryptoClient cryptoClient;
    @MockBean
    private CoinMapper coinMapper;
    @MockBean
    private CurrencyMapper currencyMapper;
    @MockBean
    private CoinDbService coinDbService;
    @MockBean
    private CurrencyDbService currencyDbService;
    @MockBean
    private AuditDbService auditDbService;


    @Test
    void getSimpleRate() throws Exception {
        //Given
        SimpleRateDto rate = new SimpleRateDto("test", "usd", BigDecimal.ONE);
        when(cryptoClient.getSimpleRate("test","usd")).thenReturn(rate);
        // When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/v1/crypto/rates?coinId=test&currency=usd")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$.rate", Matchers.is(1)))
                .andDo(print());

    }

    @Test
    void getAllRates() throws Exception {
        //Given
        List<SimpleRateDto> rateLists = List.of(new SimpleRateDto("test", "usd", BigDecimal.ONE));
        when(cryptoFacade.getAllCoinsRates("usd")).thenReturn(rateLists);
        // When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/v1/crypto/rates?currency=usd")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].coinId", Matchers.is("test")));

    }

    @Test
    void getRateForAllCurrencies() throws Exception {
        //Given
        List<SimpleRateDto> rateLists = List.of(new SimpleRateDto("ripple", "usd", BigDecimal.ONE));
        when(cryptoFacade.getRateForAllCurrencies("ripple")).thenReturn(rateLists);
        // When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/v1/crypto/rates?coinId=ripple")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].currency", Matchers.is("usd")));

    }

    @Test
    void getCoinsList() throws Exception {
        //Given
        List<CoinDto> coinDtoList = List.of(new CoinDto("test", "test", "test"));
        when(cryptoClient.getCoinsList()).thenReturn(coinDtoList);
        // When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/v1/crypto/coinsList")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200));
    }

    @Test
    void getCoins() throws Exception {
        //Given
        List<CoinDto> coinDtoList = List.of(new CoinDto("test", "test", "test"));
        List<Coin> coins = coinMapper.mapToCoinList(coinDtoList);
        when(coinDbService.getAllCoins()).thenReturn(coins);
        // When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/v1/crypto/coins")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200));
    }

    @Test
    void getCurrencies() throws Exception {
        //Given
        List<CurrencyDto> currencyDtoList = List.of(new CurrencyDto("test", "test"));
        List<Currency> currencies = currencyMapper.mapToCurrencyList(currencyDtoList);
        when(currencyDbService.getAllCurrencies()).thenReturn(currencies);
        // When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/v1/crypto/currencies")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200));
    }
}