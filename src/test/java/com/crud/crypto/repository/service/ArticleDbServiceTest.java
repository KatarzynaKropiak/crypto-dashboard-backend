package com.crud.crypto.repository.service;

import com.crud.crypto.domain.Article;
import com.crud.crypto.domain.Asset;
import com.crud.crypto.repository.ArticleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ArticleDbServiceTest {

    @Autowired
    private ArticleDbService service;
    @Autowired
    private ArticleRepository repository;

    @Test
    void saveArticle() {
        //Given
        repository.deleteAll();
        Article article = new Article();
        article.setTitle("test");
        service.saveArticle(article);
        //When
        List<Article> articles = service.getAllArticle();
        //Then
        assertEquals(1, articles.size());
        //CleanUp
        repository.deleteAll();
        service.deleteAllArticle();
    }
}