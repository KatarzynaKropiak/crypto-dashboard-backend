package com.crud.crypto.mapper;

import com.crud.crypto.domain.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AssetMapperTest {

    private AssetMapper mapper = new AssetMapper();

    @Test
    void mapToAssetDto() {
        //Given
        Asset asset = new Asset( new Wallet(1L), "test", BigDecimal.ONE, "test", BigDecimal.ONE);
        //When
        AssetDto testAssetDto = mapper.mapToAssetDto(asset);
        //Then
        assertEquals(asset.getWallet().getWalletId(), testAssetDto.getWalletId());
        assertEquals(asset.getCoinId(), testAssetDto.getCoinId());
        assertEquals(asset.getCoinValue(), testAssetDto.getCoinValue());
        assertEquals(asset.getCurrencyId(), testAssetDto.getCurrencyId());
        assertEquals(asset.getCurrencyValue(), testAssetDto.getCurrencyValue());
    }

    @Test
    void mapToAsset() {
        //Given
        AssetDto assetDto = new AssetDto( 1L, "test", BigDecimal.ONE, "test", BigDecimal.ONE);
        //When
        Asset testAsset = mapper.mapToAsset(assetDto);
        //Then
        assertEquals(assetDto.getCoinId(), testAsset.getCoinId());
        assertEquals(assetDto.getWalletId(), testAsset.getWallet().getWalletId());
        assertEquals(assetDto.getCoinValue(), testAsset.getCoinValue());
        assertEquals(assetDto.getCurrencyId(), testAsset.getCurrencyId());
        assertEquals(assetDto.getCurrencyValue(), testAsset.getCurrencyValue());
    }

    @Test
    void mapToAssetDtoList() {
        //Given
        List<Asset> assetList = new ArrayList<>();
        Asset asset = new Asset( new Wallet(1L), "test", BigDecimal.ONE, "test", BigDecimal.ONE);
        assetList.add(asset);
        //When
        List<AssetDto> assetDtos = mapper.mapToAssetDtoList(assetList);
        //Then
        assertEquals(assetList.get(0).getWallet().getWalletId(), assetDtos.get(0).getWalletId());
        assertEquals(assetList.get(0).getCoinId(), assetDtos.get(0).getCoinId());
        assertEquals(assetList.get(0).getCoinValue(), assetDtos.get(0).getCoinValue());
        assertEquals(assetList.get(0).getCurrencyId(), assetDtos.get(0).getCurrencyId());
        assertEquals(assetList.get(0).getCurrencyValue(), assetDtos.get(0).getCurrencyValue());
    }
}