package com.crud.crypto.controller;


import com.crud.crypto.domain.*;
import com.crud.crypto.exception.AssetNotFoundException;
import com.crud.crypto.exception.WalletNotFoundException;
import com.crud.crypto.facade.WalletFacade;
import com.crud.crypto.mapper.AssetMapper;
import com.crud.crypto.mapper.WalletMapper;
import com.crud.crypto.repository.service.AssetDbService;
import com.crud.crypto.repository.service.AuditDbService;
import com.crud.crypto.repository.service.WalletDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("v1/crypto")
@RequiredArgsConstructor
@CrossOrigin("*")
public class WalletController {

    private final WalletDbService walletDbService;
    private final WalletMapper walletMapper;
    private final AssetDbService assetDbService;
    private final AssetMapper assetMapper;
    private final WalletFacade walletFacade;
    private final AuditDbService auditDbService;

    @GetMapping("wallets")
    public ResponseEntity<List<WalletDto>> getWallets()
    {
        List<Wallet> wallets = walletDbService.getAllWallets();
        auditDbService.savelog(new AuditLog("getWallets", LocalDateTime.now()));

        return ResponseEntity.ok(walletMapper.mapToWalletDtoList(wallets));
    }

    @GetMapping(value = "wallets/{walletId}")
    public ResponseEntity<WalletDto> getWallet(@PathVariable Long walletId) throws WalletNotFoundException {
        auditDbService.savelog(new AuditLog("getWallet", LocalDateTime.now()));

        return ResponseEntity.ok(walletMapper.mapToWalletDto(walletDbService.getWalletById(walletId)));
    }


    @DeleteMapping(value = "wallets/{walletId}")
    public ResponseEntity<Void> deleteWallet(@PathVariable Long walletId) {
        walletDbService.deleteWallet(walletId);
        auditDbService.savelog(new AuditLog("deleteWallet", LocalDateTime.now()));

        return ResponseEntity.ok().build();
    }
    @DeleteMapping("wallets")
    public ResponseEntity<Void> deleteAllWallets() {
        walletDbService.deleteAllWallets();
        auditDbService.savelog(new AuditLog("deleteAllWallets", LocalDateTime.now()));

        return ResponseEntity.ok().build();
    }

    @PutMapping(value="wallets/{walletId}")
    public ResponseEntity<WalletDto> updateWallet(@RequestBody WalletDto walletDto) {
        Wallet wallet = walletMapper.mapToWallet(walletDto);
        Wallet savedWallet = walletDbService.saveWallet(wallet);
        auditDbService.savelog(new AuditLog("updateWallet", LocalDateTime.now()));

        return ResponseEntity.ok(walletMapper.mapToWalletDto(savedWallet));
    }

    @PostMapping(value="wallets", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createWallet(@RequestBody WalletDto walletDto) {
        Wallet wallet = walletMapper.mapToWallet(walletDto);
        walletDbService.saveWallet(wallet);
        auditDbService.savelog(new AuditLog("createWallet", LocalDateTime.now()));

        return ResponseEntity.ok().build();
    }

    @GetMapping("wallets/{walletId}/assets")
    public ResponseEntity<List<AssetDto>> getAssets(@PathVariable Long walletId) throws WalletNotFoundException {
        auditDbService.savelog(new AuditLog("getAssets", LocalDateTime.now()));

        return ResponseEntity.ok(walletFacade.getAssets(walletId));
    }

    @GetMapping(value = "assets/{id}")
    public ResponseEntity<AssetDto> getAsset(@PathVariable Long id) throws AssetNotFoundException {
        auditDbService.savelog(new AuditLog("getAsset", LocalDateTime.now()));

        return ResponseEntity.ok(assetMapper.mapToAssetDto(assetDbService.getAssetById(id)));
    }


    @DeleteMapping(value = "assets/{id}")
    public ResponseEntity<Void> deleteAsset(@PathVariable Long id) {
        assetDbService.deleteAsset(id);
        auditDbService.savelog(new AuditLog("deleteAsset", LocalDateTime.now()));

        return ResponseEntity.ok().build();
    }
    @DeleteMapping("assets")
    public ResponseEntity<Void> deleteAllAssets() {
        assetDbService.deleteAllAssets();
        auditDbService.savelog(new AuditLog("deleteAllAssets", LocalDateTime.now()));

        return ResponseEntity.ok().build();
    }

    @PutMapping(value="assets/{id}")
    public ResponseEntity<AssetDto> updateAsset(@RequestBody AssetDto assetDto) {
        Asset asset = assetMapper.mapToAsset(assetDto);
        Asset savedAsset = assetDbService.saveAsset(asset);
        auditDbService.savelog(new AuditLog("updateAsset", LocalDateTime.now()));

        return ResponseEntity.ok(assetMapper.mapToAssetDto(savedAsset));
    }

    @PostMapping(value="assets", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createAsset(@RequestBody AssetDto assetDto) {
        Asset asset = assetMapper.mapToAsset(assetDto);
        assetDbService.saveAsset(asset);
        auditDbService.savelog(new AuditLog("createAsset", LocalDateTime.now()));

        return ResponseEntity.ok().build();

    }
}
