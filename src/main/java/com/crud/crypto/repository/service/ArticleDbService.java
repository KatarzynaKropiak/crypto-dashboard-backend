package com.crud.crypto.repository.service;

import com.crud.crypto.domain.Article;
import com.crud.crypto.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleDbService {

    @Autowired
    private ArticleRepository repository;

    public List<Article> getAllArticle() {
        return repository.findAll();
    }

    public Article saveArticle(final Article article) {
        return repository.save(article);
    }

    public void deleteAllArticle() { repository.deleteAll(); }

}
