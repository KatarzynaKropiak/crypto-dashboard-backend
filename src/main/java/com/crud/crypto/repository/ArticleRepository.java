package com.crud.crypto.repository;

import com.crud.crypto.domain.Article;
import com.crud.crypto.domain.News;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ArticleRepository  extends CrudRepository<Article, Long> {

    @Override
    List<Article> findAll();

    @Override
    Article save(Article article);

    @Override
    void deleteAll();
}
