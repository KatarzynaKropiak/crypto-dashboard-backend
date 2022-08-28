package com.crud.crypto.client;

import com.crud.crypto.config.CryptoConfig;
import com.crud.crypto.domain.Article;
import com.crud.crypto.domain.NewsDto;
import com.crud.crypto.domain.SimpleRateDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


//@ExtendWith(MockitoExtension.class)
class CryptoNewsClientTest {

//    @InjectMocks
//    private CryptoNewsClient client;
//    @Mock
//    private RestTemplate restTemplate;
//    @Mock
//    private CryptoConfig config;
//    @Mock
//    private LocalDate localDate;

//    @Test
//    void getNews() throws URISyntaxException {
//        // Given
//        when(config.getCryptoNewsApiEndpoint()).thenReturn("http://test.com/");
//        when(config.getRapidapiKey()).thenReturn("test");
//        when(localDate.now()).thenReturn(LocalDate.parse("2022-08-22"));
//
//        Article[] articles = new Article[1];
//        Article article = new Article(1L, "title", "url");
//        articles[0] = article;
//        NewsDto newsDto = new NewsDto("message", articles);
////        List<NewsDto> newsDtoList = new ArrayList<>();
////        newsDtoList.add(newsDto);
//
//
//        URI uri = new URI("http://test.com/test?start_date=2022-08-22&end_date=2022-08-19&rapid-api-key=test");
//
//        when(restTemplate.getForObject(uri, NewsDto.class)).thenReturn(newsDto);
//
//
//        // When
//        List<NewsDto> newsDtos = client.getNews("test");
//
//        // Then
//        assertEquals("message", newsDtos.get(0).getMessage());
//
//
//    }
//
//
//    @Test
//    void getAllNews() {
//    }
}