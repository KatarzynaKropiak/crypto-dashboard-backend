package com.crud.crypto.repository;

import com.crud.crypto.domain.Wallet;
import org.springframework.data.repository.CrudRepository;

public interface WalletRepository extends CrudRepository<Wallet, Long> {


    Wallet findWalletBy();
    }
