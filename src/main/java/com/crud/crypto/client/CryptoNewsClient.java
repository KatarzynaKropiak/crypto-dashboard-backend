package com.crud.crypto.client;

import com.crud.crypto.domain.CoinDto;
import com.crud.crypto.domain.NewsDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.time.LocalDate;
import java.util.*;


@Component
@RequiredArgsConstructor
@Getter
public class CryptoNewsClient {

    private final RestTemplate restTemplate;

    @Value("${cryptonewstoday.api.endpoint.prod}")
        private String cryptoNewsApiEndpoint;
    @Value("${cryptonewstoday.api.key}")
        private String rapidapiKey;


    public List<NewsDto> getNews(String coinId) {
        URI url = UriComponentsBuilder.fromHttpUrl(
                        cryptoNewsApiEndpoint + coinId)
                .queryParam("start_date", LocalDate.now().minusDays(3L))
                .queryParam("end_date", LocalDate.now())
                .queryParam("rapidapi-key", rapidapiKey)
                .build()
                .encode()
                .toUri();

        NewsDto newsTodayResponse = restTemplate.getForObject(url, NewsDto.class);
        System.out.println(newsTodayResponse);

        return Optional.ofNullable(newsTodayResponse)
                .map(Arrays::asList)
                .orElse(Collections.emptyList());
    }

        public List<NewsDto> getAllNews() {
            URI url = UriComponentsBuilder.fromHttpUrl(
                        cryptoNewsApiEndpoint)
                .queryParam("start_date", LocalDate.now().minusDays(3L))
                .queryParam("end_date", LocalDate.now())
                .queryParam("rapidapi-key",rapidapiKey)
                .build()
                .encode()
                .toUri();

//            Map<String, String> headers = new HashMap<>();
//            headers.put("X-RapidAPI-Key", "02494de011msh2e37f20e09eed1ap1ba510jsn48b6c7643376");
//            headers.put("X-RapidAPI-Host", "crypto-news-today.p.rapidapi.com");
//
//            RequestEntity requestEntity = new RequestEntity(headers, HttpMethod.GET, url);
//            System.out.println(requestEntity);
//
//
//            ResponseEntity<NewsDto[]> newsTodayResponse = restTemplate.exchange(url, HttpMethod.GET, requestEntity, NewsDto[].class);
//
//
//            return Optional.ofNullable(newsTodayResponse.getBody())
//                .map(Arrays::asList)
//                .orElse(Collections.emptyList());

            NewsDto newsTodayResponse = restTemplate.getForObject(url, NewsDto.class);

            return Optional.ofNullable(newsTodayResponse)
                    .map(Arrays::asList)
                    .orElse(Collections.emptyList());
    }

    }
