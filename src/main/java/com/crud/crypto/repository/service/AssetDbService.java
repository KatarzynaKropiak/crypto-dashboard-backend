package com.crud.crypto.repository.service;

import com.crud.crypto.domain.Asset;
import com.crud.crypto.exception.AssetNotFoundException;
import com.crud.crypto.repository.AssetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AssetDbService {

    @Autowired
    private final AssetRepository repository;

    public List<Asset> getAllAssets() {
        return repository.findAll();
    }

    public Asset getAssetById(final long id) throws AssetNotFoundException {
        return repository.findById(id).orElseThrow(AssetNotFoundException::new);
    }

    public Asset saveAsset(final Asset asset) {
        return repository.save(asset);
    }

    public void deleteAsset(final long id) {
        repository.deleteById(id);
    }

    public void deleteAllAssets() { repository.deleteAll(); }

}
