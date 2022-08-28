package com.crud.crypto.mapper;

import com.crud.crypto.domain.Asset;
import com.crud.crypto.domain.AssetDto;
import com.crud.crypto.domain.Wallet;
import lombok.Getter;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Getter
@Service
public class AssetMapper {

    public AssetDto mapToAssetDto(final Asset asset) {
        return new AssetDto(
                asset.getWallet().getWalletId(),
                asset.getCoinId(),
                asset.getCoinValue(),
                asset.getCurrencyId(),
                asset.getCurrencyValue()
        );
    }

    public Asset mapToAsset(final AssetDto assetDto) {
        return new Asset(
                new Wallet(assetDto.getWalletId()),
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
