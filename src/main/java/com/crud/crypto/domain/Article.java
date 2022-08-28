package com.crud.crypto.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity(name = "article")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Article {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    private Long id;
    @JsonProperty("title")
    private String title;
    @JsonProperty("url")
    private String url;

    public void setTitle(String title) {
        this.title = title;
    }
}
