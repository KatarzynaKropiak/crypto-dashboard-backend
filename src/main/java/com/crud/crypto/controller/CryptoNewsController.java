package com.crud.crypto.controller;

import com.crud.crypto.client.CryptoNewsClient;
import com.crud.crypto.domain.AuditLog;
import com.crud.crypto.domain.CoinDto;
import com.crud.crypto.domain.NewsDto;
import com.crud.crypto.facade.NewsFacade;
import com.crud.crypto.repository.service.AuditDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("v1/crypto")
@RequiredArgsConstructor
@CrossOrigin("*")
public class CryptoNewsController {

    private final NewsFacade newsFacade;
    private final AuditDbService auditDbService;

    @GetMapping(value = "news", params = "coinId")
    public ResponseEntity<List<NewsDto>> getNews(@RequestParam String coinId) {
        auditDbService.savelog(new AuditLog("getNews", LocalDateTime.now()));
        return ResponseEntity.ok(newsFacade.getNews(coinId));
    }

    @GetMapping("news")
    public ResponseEntity<List<NewsDto>> getNewsList() {
        auditDbService.savelog(new AuditLog("getNewsList", LocalDateTime.now()));
        return ResponseEntity.ok(newsFacade.getNewsList());
    }

}
