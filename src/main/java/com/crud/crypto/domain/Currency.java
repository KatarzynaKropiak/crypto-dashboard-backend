package com.crud.crypto.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "currencies")
public class Currency {

    @javax.persistence.Id
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;


}


