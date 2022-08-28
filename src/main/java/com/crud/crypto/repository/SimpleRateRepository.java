package com.crud.crypto.repository;

import com.crud.crypto.domain.SimpleRate;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SimpleRateRepository extends CrudRepository<SimpleRate, Long> {

    @Override
    SimpleRate save(SimpleRate simpleRate);

    @Override
    void deleteAll();

    @Override
    List<SimpleRate> findAll();


}
