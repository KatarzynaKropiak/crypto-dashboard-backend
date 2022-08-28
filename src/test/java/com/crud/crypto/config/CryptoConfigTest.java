package com.crud.crypto.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNull;

class CryptoConfigTest {


    @Test
    void getCryptoNewsApiEndpoint() {
        //Given
        CryptoConfig config = new CryptoConfig();
        //When
        String CryptoNewsApiEndpoint = config.getCryptoNewsApiEndpoint();
        //Then
        assertNull(CryptoNewsApiEndpoint);
    }

    @Test
    void getRapidapiKey() {
        //Given
        CryptoConfig config = new CryptoConfig();
        //When
        String RapidapiKey = config.getRapidapiKey();
        //Then
        assertNull(RapidapiKey);
    }


    @Test
    void getCoingeckoApiEndpoint() {
        //Given
        CryptoConfig config = new CryptoConfig();
        //When
        String CoingeckoApiEndpoint = config.getCoingeckoApiEndpoint();
        //Then
        assertNull(CoingeckoApiEndpoint);
    }

}