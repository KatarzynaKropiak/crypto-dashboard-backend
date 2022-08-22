package com.crud.crypto.repository;

import com.crud.crypto.domain.Currency;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CurrencyRepository extends CrudRepository<Currency, Long> {
    @Override
    List<Currency> findAll();

}

