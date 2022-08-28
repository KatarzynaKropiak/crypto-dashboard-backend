package com.crud.crypto.repository.service;


import com.crud.crypto.domain.SimpleRate;
import com.crud.crypto.repository.SimpleRateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class SimpleRateDbService {

    @Autowired
    private final SimpleRateRepository repository;


    public SimpleRate saveSimpleRate(SimpleRate simpleRate) {
        return repository.save(simpleRate);
    }
    public void deleteAllSimpleRates() { repository.deleteAll(); }

    public List<SimpleRate> findAllSimpleRates()  {
        return repository.findAll();
    }

}
