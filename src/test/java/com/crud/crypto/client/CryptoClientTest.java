package com.crud.crypto.client;

import com.crud.crypto.controller.CoingeckoController;
import com.crud.crypto.domain.SimpleRateDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.shortThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CryptoClientTest {

    @Mock
    private SimpleRateDto simpleRateDto;
    @Mock
    private RestTemplate restTemplate;
    @Mock
    private CryptoClient cryptoClient;


    @Test
    void getSimpleRate() throws URISyntaxException {

        when(cryptoClient.getCoingeckoApiEndpoint()).thenReturn("http://test.com/");
        when(simpleRateDto.getCurrency()).thenReturn("usd");
        when(simpleRateDto.getCoinId()).thenReturn("ripple");

        URI uri = new URI("http://test.com/simple/price?ids=ripple&vs_currencies=usd");

        when(restTemplate.getForObject(uri, SimpleRateDto.class)).thenReturn(simpleRateDto);

    }
}