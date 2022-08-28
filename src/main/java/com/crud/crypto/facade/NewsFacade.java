package com.crud.crypto.facade;

import com.crud.crypto.client.CryptoNewsClient;
import com.crud.crypto.domain.NewsDto;
import com.crud.crypto.mapper.NewsMapper;
import com.crud.crypto.repository.service.ArticleDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class NewsFacade {
    private final ArticleDbService articleDbService;
    private final CryptoNewsClient client;
    private final NewsMapper newsMapper;

    public List<NewsDto> getNews(String coinId) {
        List<NewsDto> coinNewsList = client.getNews(coinId);

        coinNewsList.stream().map(news -> newsMapper.mapToArticleList(news)
                .stream()
                .map(article -> articleDbService.saveArticle(article)));


        return coinNewsList;
    }

    public List<NewsDto> getNewsList() {
        List<NewsDto> coinNewsList = client.getAllNews();
        coinNewsList.stream().map(news -> newsMapper.mapToArticleList(news)
                .stream()
                .map(article -> articleDbService.saveArticle(article)));

        return coinNewsList;
    }
}
