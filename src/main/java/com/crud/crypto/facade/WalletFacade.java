package com.crud.crypto.facade;

import com.crud.crypto.domain.Asset;
import com.crud.crypto.domain.AssetDto;
import com.crud.crypto.exception.WalletNotFoundException;
import com.crud.crypto.mapper.AssetMapper;
import com.crud.crypto.repository.WalletRepository;
import com.crud.crypto.repository.service.AssetDbService;
import com.crud.crypto.repository.service.WalletDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class WalletFacade {

    private final AssetDbService assetDbService;
    private final AssetMapper assetMapper;

    public List<AssetDto> getAssets(Long walletId)
    {
        List<Asset> assets = assetDbService.getAllAssets();
        assets.stream()
                .filter(asset -> asset.getWallet().getWalletId()==walletId)
                .collect(Collectors.toList());
        List<AssetDto> assetDtos = assetMapper.mapToAssetDtoList(assets);
        return assetDtos;
    }

}
