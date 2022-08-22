package com.crud.crypto.client;

import com.crud.crypto.domain.CoinDto;
import com.crud.crypto.domain.SimpleRateDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
@Getter
public class CryptoClient {

    private final RestTemplate restTemplate;


    @Value("${coingecko.api.endpoint.prod}")
    private String coingeckoApiEndpoint;

    public SimpleRateDto getSimpleRate(String coinId, String currency) {
        URI url = UriComponentsBuilder.fromHttpUrl(
                coingeckoApiEndpoint + "/simple/price")
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
                coingeckoApiEndpoint + "/coins/list")
                .build()
                .encode()
                .toUri();

        CoinDto[] boardsResponse = restTemplate.getForObject(url, CoinDto[].class);

        return Optional.ofNullable(boardsResponse)
                .map(Arrays::asList)
                .orElse(Collections.emptyList());
    }

}