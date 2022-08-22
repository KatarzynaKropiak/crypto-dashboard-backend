package com.crud.crypto.repository.service;

import com.crud.crypto.domain.Currency;
import com.crud.crypto.repository.CurrencyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CurrencyDbService {

    @Autowired
    private final CurrencyRepository repository;


    public List<Currency> getAllCurrencies() {
        return repository.findAll();
    }

}
