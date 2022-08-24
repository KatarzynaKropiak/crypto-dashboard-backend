package com.crud.crypto.controller;


import com.crud.crypto.domain.Asset;
import com.crud.crypto.domain.AssetDto;
import com.crud.crypto.domain.Wallet;
import com.crud.crypto.domain.WalletDto;
import com.crud.crypto.exception.AssetNotFoundException;
import com.crud.crypto.exception.WalletNotFoundException;
import com.crud.crypto.mapper.AssetMapper;
import com.crud.crypto.mapper.WalletMapper;
import com.crud.crypto.repository.service.AssetDbService;
import com.crud.crypto.repository.service.WalletDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/crypto")
@RequiredArgsConstructor
@CrossOrigin("*")
public class WalletController {

    private final WalletDbService walletDbService;
    private final WalletMapper walletMapper;
    private final AssetDbService assetDbService;
    private final AssetMapper assetMapper;

    @GetMapping("wallets")
    public ResponseEntity<List<WalletDto>> getWallets()
    {
        List<Wallet> wallets = walletDbService.getAllWallets();
        return ResponseEntity.ok(walletMapper.mapToWalletDtoList(wallets));
    }

    @GetMapping(value = "wallet/{walletId}")
    public ResponseEntity<WalletDto> getWallet(@PathVariable Long walletId) throws WalletNotFoundException {
        return ResponseEntity.ok(walletMapper.mapToWalletDto(walletDbService.getWalletById(walletId)));
    }


    @DeleteMapping(value = "deleteWallet/{walletId}")
    public ResponseEntity<Void> deleteWallet(@PathVariable Long walletId) {
        walletDbService.deleteWallet(walletId);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("deleteAllWallets")
    public ResponseEntity<Void> deleteAllWallets() {
        walletDbService.deleteAllWallets();
        return ResponseEntity.ok().build();
    }

    @PutMapping(value="updateWallet/{walletId}")
    public ResponseEntity<WalletDto> updateWallet(@RequestBody WalletDto walletDto) {
        Wallet wallet = walletMapper.mapToWallet(walletDto);
        Wallet savedWallet = walletDbService.saveWallet(wallet);
        return ResponseEntity.ok(walletMapper.mapToWalletDto(savedWallet));
    }

    @PostMapping(value="addWallet", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createWallet(@RequestBody WalletDto walletDto) {
        Wallet wallet = walletMapper.mapToWallet(walletDto);
        walletDbService.saveWallet(wallet);
        return ResponseEntity.ok().build();
    }

    @GetMapping("assets")
    public ResponseEntity<List<AssetDto>> getAssets()
    {
        List<Asset> assets = assetDbService.getAllAssets();
        return ResponseEntity.ok(assetMapper.mapToAssetDtoList(assets));
    }

    @GetMapping(value = "asset/{id}")
    public ResponseEntity<AssetDto> getAsset(@PathVariable Long id) throws AssetNotFoundException {
        return ResponseEntity.ok(assetMapper.mapToAssetDto(assetDbService.getAssetById(id)));
    }


    @DeleteMapping(value = "deleteAsset/{id}")
    public ResponseEntity<Void> deleteAsset(@PathVariable Long id) {
        assetDbService.deleteAsset(id);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("deleteAllAssets")
    public ResponseEntity<Void> deleteAllAssets() {
        assetDbService.deleteAllAssets();
        return ResponseEntity.ok().build();
    }

    @PutMapping(value="updateAsset/{id}")
    public ResponseEntity<AssetDto> updateAsset(@RequestBody AssetDto assetDto) {
        Asset asset = assetMapper.mapToAsset(assetDto);
        Asset savedAsset = assetDbService.saveAsset(asset);
        return ResponseEntity.ok(assetMapper.mapToAssetDto(savedAsset));
    }

    @PostMapping(value="addAsset", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createAsset(@RequestBody AssetDto assetDto) {
        Asset asset = assetMapper.mapToAsset(assetDto);
        assetDbService.saveAsset(asset);
        return ResponseEntity.ok().build();

    }
}
