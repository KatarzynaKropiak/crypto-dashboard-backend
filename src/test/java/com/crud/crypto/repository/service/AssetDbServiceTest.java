package com.crud.crypto.repository.service;

import com.crud.crypto.domain.Asset;
import com.crud.crypto.domain.Wallet;
import com.crud.crypto.exception.AssetNotFoundException;
import com.crud.crypto.repository.AssetRepository;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AssetDbServiceTest {

    @Autowired
    private AssetDbService service;

    @Autowired
    private AssetRepository assetRepository;

    @Test
    void getAllAssets() {
        //Given
        assetRepository.deleteAll();
        Asset asset = new Asset();
        assetRepository.save(asset);
        //When
        List<Asset> assetList = service.getAllAssets();
        //Then
        assertEquals(1, assetList.size());
        //CleanUp
        assetRepository.deleteAll();
    }

    @Test
    void getAssetById() throws AssetNotFoundException {
        //Given
        assetRepository.deleteAll();
        Asset asset = new Asset();
        assetRepository.save(asset);
        service.getAssetById(asset.getId());

        //Then
        assertEquals(asset.getId(), service.getAssetById(asset.getId()).getId());

        //CleanUp
        assetRepository.deleteAll();

    }
    @Test
    void saveAsset() {
        //Given
        service.deleteAllAssets();
        Asset asset = new Asset();
        asset.setId(1L);
        service.saveAsset(asset);
        //When
        List<Asset> assetList = service.getAllAssets();
        //Then
        assertEquals(1, assetList.size());
        //CleanUp
        assetRepository.deleteAll();
    }

    @Test
    void deleteAsset() {
        //Given
        assetRepository.deleteAll();
        Asset asset = new Asset();
        assetRepository.save(asset);
        //When
        service.deleteAsset(asset.getId());
        //Then
        assertFalse(assetRepository.existsById(asset.getId()));
    }

    @Test
    void deleteAllAssets() {
        service.deleteAllAssets();
        assertTrue(assetRepository.findAll().isEmpty());
    }
}