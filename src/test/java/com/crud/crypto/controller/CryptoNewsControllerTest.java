package com.crud.crypto.controller;

import com.crud.crypto.domain.Article;
import com.crud.crypto.domain.NewsDto;
import com.crud.crypto.domain.SimpleRateDto;
import com.crud.crypto.facade.NewsFacade;
import com.crud.crypto.repository.service.AuditDbService;
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
@WebMvcTest(CryptoNewsController.class)
@AutoConfigureMockMvc
class CryptoNewsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private NewsFacade newsFacade;
    @MockBean
    private AuditDbService auditDbService;

    @Test
    void getNews() throws Exception {
        //Given
        Article[] articles = new Article[1];
        Article article = new Article(1L, "title", "url");
        articles[0] = article;
        List<NewsDto> news = List.of(new NewsDto("test", articles));

        when(newsFacade.getNews("test")).thenReturn(news);
        // When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/v1/crypto/news?coinId=test")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].message", Matchers.is("test")))
                .andDo(print());
    }

    @Test
    void getNewsList() throws Exception {
        //Given
        Article[] articles = new Article[1];
        Article article = new Article(1L, "title", "url");
        articles[0] = article;
        List<NewsDto> news = List.of(new NewsDto("test", articles));

        when(newsFacade.getNewsList()).thenReturn(news);
        // When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/v1/crypto/news")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].message", Matchers.is("test")))
                .andDo(print());
    }

}