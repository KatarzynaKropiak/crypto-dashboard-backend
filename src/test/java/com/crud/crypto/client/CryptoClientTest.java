package com.crud.crypto.client;

import com.crud.crypto.config.CryptoConfig;
import com.crud.crypto.controller.CoingeckoController;
import com.crud.crypto.domain.CoinDto;
import com.crud.crypto.domain.SimpleRateDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.shortThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CryptoClientTest {

    @InjectMocks
    private CryptoClient cryptoClient;

    @Mock
    private RestTemplate restTemplate;
    @Mock
    private CryptoConfig config;




    @Test
    void getSimpleRate() throws URISyntaxException {

        // Given
        when(config.getCoingeckoApiEndpoint()).thenReturn("http://test.com/");

        SimpleRateDto simpleRateDto = new SimpleRateDto("test", "test", new BigDecimal(1));

        URI uri = new URI("http://test.com/simple/price?ids=test&vs_currencies=test");

        when(restTemplate.getForObject(uri, SimpleRateDto.class)).thenReturn(simpleRateDto);


        // When
        SimpleRateDto simpleRateDto1 = cryptoClient.getSimpleRate("test", "test");

            // Then
            assertEquals("test", simpleRateDto1.getCoinId());
            assertEquals("test", simpleRateDto1.getCurrency());
            assertEquals(BigDecimal.ONE, simpleRateDto1.getRate());

    }

    @Test
    void getCoinList() throws URISyntaxException {

        // Given
        when(config.getCoingeckoApiEndpoint()).thenReturn("http://test.com/");

        CoinDto[] coinDto = new CoinDto[1];
        coinDto[0] = new CoinDto("test", "test", "test");


        URI uri = new URI("http://test.com/coins/list");

        when(restTemplate.getForObject(uri, CoinDto[].class)).thenReturn(coinDto);

        // When
        List<CoinDto> coinDtos1 = cryptoClient.getCoinsList();

        // Then
        assertEquals("test", coinDtos1.get(0).getId());
        assertEquals("test", coinDtos1.get(0).getName());
        assertEquals("test", coinDtos1.get(0).getSymbol());


    }

}