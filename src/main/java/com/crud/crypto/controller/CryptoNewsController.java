package com.crud.crypto.controller;

import com.crud.crypto.client.CryptoNewsClient;
import com.crud.crypto.domain.CoinDto;
import com.crud.crypto.domain.NewsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/crypto")
@RequiredArgsConstructor
@CrossOrigin("*")
public class CryptoNewsController {

    private final CryptoNewsClient cryptoNewsClient;

    @GetMapping("news")
    public ResponseEntity<List<NewsDto>> getNews(@RequestParam String coinId) {
        return ResponseEntity.ok(cryptoNewsClient.getNews(coinId));
    }

    @GetMapping("allnews")
    public ResponseEntity<List<NewsDto>> getNewsList() {
        return ResponseEntity.ok(cryptoNewsClient.getAllNews());
    }

}
