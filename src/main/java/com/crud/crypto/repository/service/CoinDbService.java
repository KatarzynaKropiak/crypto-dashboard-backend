package com.crud.crypto.repository.service;

import com.crud.crypto.domain.Coin;
import com.crud.crypto.repository.CoinRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CoinDbService {
    @Autowired
    private final CoinRepository repository;

        public List<Coin> getAllCoins() {
            return repository.findAll();
        }

}
