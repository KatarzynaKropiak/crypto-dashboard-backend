package com.crud.crypto.repository;

import com.crud.crypto.domain.Asset;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface AssetRepository extends CrudRepository<Asset, Long> {
    @Override
    List<Asset> findAll();

    @Override
    Asset save(Asset asset);

    @Override
    Optional<Asset> findById(Long id);

    @Override
    void deleteById(Long id);

    @Override
    void deleteAll();


}

