package com.crud.crypto.facade;

import com.crud.crypto.client.CryptoClient;
import com.crud.crypto.controller.CoingeckoController;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CryptoFacade {
    private static final Logger LOGGER = LoggerFactory.getLogger(CryptoFacade.class);

    private final CryptoClient cryptoClient;
}