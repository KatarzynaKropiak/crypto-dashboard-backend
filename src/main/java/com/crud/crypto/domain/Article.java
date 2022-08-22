package com.crud.crypto.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Article {

    @JsonProperty("title")
    private String title;
    @JsonProperty("url")
    private String url;
}
