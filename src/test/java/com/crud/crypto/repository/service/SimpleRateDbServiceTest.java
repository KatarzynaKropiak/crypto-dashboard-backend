package com.crud.crypto.repository.service;

import com.crud.crypto.domain.SimpleRate;
import com.crud.crypto.repository.SimpleRateRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SimpleRateDbServiceTest {

    @Autowired
    private SimpleRateRepository repository;

    @Autowired
    private SimpleRateDbService service;


    @Test
    void saveSimpleRate() {
        //Given
        service.deleteAllSimpleRates();
        SimpleRate simpleRate = new SimpleRate();
        service.saveSimpleRate(simpleRate);
        //When
        List<SimpleRate> simpleRates = service.findAllSimpleRates();
        //Then
        assertEquals(1, simpleRates.size());
        //CleanUp
        repository.deleteAll();
    }
    }
