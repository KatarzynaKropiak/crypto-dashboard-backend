package com.crud.crypto.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Entity(name = "coins")
public class Coin {

    @javax.persistence.Id
    @Id
    @NotNull
    @Column(name = "id")

    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "symbol")
    private String symbol;


}
