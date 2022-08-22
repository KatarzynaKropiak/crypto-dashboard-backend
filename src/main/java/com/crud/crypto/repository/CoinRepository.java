package com.crud.crypto.repository;

import com.crud.crypto.domain.Coin;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CoinRepository extends CrudRepository<Coin, Long>

    {
        @Override
        List<Coin> findAll();

//        @Override
//        Coin save(Coin coin);
//
//        @Override
//        Optional<Coin> findById(Long id);
//
//        @Override
//        void deleteById(Long id);
    }

