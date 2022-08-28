package com.crud.crypto.mapper;

import com.crud.crypto.domain.*;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NewsMapper {

    public List<Article> mapToArticleList(final NewsDto newsDto) {
        return Arrays.stream(newsDto
                .getNews()).collect(Collectors.toList());
    }
}
