package com.crud.crypto.mapper;

import com.crud.crypto.domain.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NewsMapperTest {

    private NewsMapper mapper = new NewsMapper();

    @Test
    void mapToArticleList() {
        //Given
        Article[] articles = new Article[1];
        Article article = new Article(1L, "title", "url");
        articles[0] = article;
        NewsDto newsDto = new NewsDto("message", articles);
        //When
        List<Article> articleList = mapper.mapToArticleList(newsDto);
        //Then
        assertEquals(articleList.get(0).getUrl(), articles[0].getUrl());
    }
}