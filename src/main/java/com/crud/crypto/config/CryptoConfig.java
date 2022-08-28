package com.crud.crypto.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class CryptoConfig {

    @Value("${cryptonewstoday.api.endpoint.prod}")
    private String cryptoNewsApiEndpoint;
    @Value("${cryptonewstoday.api.key}")
    private String rapidapiKey;
    @Value("${coingecko.api.endpoint.prod}")
    private String coingeckoApiEndpoint;

}
