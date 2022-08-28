package com.crud.crypto.client;

import com.crud.crypto.config.CryptoConfig;
import com.crud.crypto.domain.CoinDto;
import com.crud.crypto.domain.SimpleRateDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.*;

@Component
@RequiredArgsConstructor
@Getter
public class CryptoClient {

    private final RestTemplate restTemplate;
    private final CryptoConfig cryptoConfig;



    public SimpleRateDto getSimpleRate(String coinId, String currency) {
        URI url = UriComponentsBuilder.fromHttpUrl(
                cryptoConfig.getCoingeckoApiEndpoint() + "/simple/price")
                .queryParam("ids", coinId)
                .queryParam( "vs_currencies", currency)
                .build()
                .encode()
                .toUri();

        SimpleRateDto coingeckoResponse = restTemplate.getForObject(url, SimpleRateDto.class);

       return coingeckoResponse;
    }


    public List<CoinDto> getCoinsList() {
        URI url = UriComponentsBuilder.fromHttpUrl(
                cryptoConfig.getCoingeckoApiEndpoint() + "/coins/list")
                .build()
                .encode()
                .toUri();

        CoinDto[] coingeckoResponse = restTemplate.getForObject(url, CoinDto[].class);

        return Optional.ofNullable(coingeckoResponse)
                .map(Arrays::asList)
                .orElse(Collections.emptyList());
    }

}