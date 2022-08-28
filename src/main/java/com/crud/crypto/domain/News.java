package com.crud.crypto.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "news")
public class News {
    @javax.persistence.Id
    @Id
    @NotNull
    @Column(name = "id")
    private Long id;

    @Column(name = "url")
    private String url;

    @Column(name = "symbol")
    private String symbol;

    @Column(name = "date")
    private LocalDate date;

}
