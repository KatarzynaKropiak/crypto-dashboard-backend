package com.crud.crypto.repository;

import com.crud.crypto.domain.Wallet;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface WalletRepository extends CrudRepository<Wallet, Long> {


    @Override
    List<Wallet> findAll();

    @Override
    Wallet save(Wallet wallet);

    @Override
    Optional<Wallet> findById(Long id);

    @Override
    void deleteById(Long id);

    @Override
    void deleteAll();
}
