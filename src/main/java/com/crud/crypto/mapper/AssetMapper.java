package com.crud.crypto.mapper;

import com.crud.crypto.domain.Asset;
import com.crud.crypto.domain.AssetDto;
import lombok.Data;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Data
@Service
public class AssetMapper {

    public AssetDto mapToAssetDto(final Asset asset) {
        return new AssetDto(
                asset.getId(),
                asset.getName(),
                asset.getCoinId(),
                asset.getCoinValue(),
                asset.getCurrencyId(),
                asset.getCurrencyValue()
        );
    }

    public Asset mapToAsset(final AssetDto assetDto) {
        return new Asset(
                assetDto.getId(),
                assetDto.getName(),
                assetDto.getCoinId(),
                assetDto.getCoinValue(),
                assetDto.getCurrencyId(),
                assetDto.getCurrencyValue()
        );
    }

    public List<AssetDto> mapToAssetDtoList(final List<Asset> assetList) {
        return assetList.stream()
                .map(this::mapToAssetDto)
                .collect(Collectors.toList());
    }
}
