package com.crud.crypto.mapper;

import com.crud.crypto.domain.Coin;
import com.crud.crypto.domain.CoinDto;
import com.crud.crypto.domain.SimpleRate;
import com.crud.crypto.domain.SimpleRateDto;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class SimpleRateMapperTest {

    private SimpleRateMapper mapper = new SimpleRateMapper();

    @Test
    void mapToSimpleRateDto() {
        //Given
        SimpleRate simpleRate = new SimpleRate("test", "test", BigDecimal.ONE);
        //When
        SimpleRateDto testRateDto = mapper.mapToSimpleRateDto(simpleRate);
        //Then
        assertEquals(simpleRate.getCoinId(), testRateDto.getCoinId());
        assertEquals(simpleRate.getCurrency(), testRateDto.getCoinId());
        assertEquals(simpleRate.getRate(), testRateDto.getRate());
    }


    @Test
    void mapToSimpleRate() {
        //Given
        SimpleRateDto simpleRateDto = new SimpleRateDto("test", "test", BigDecimal.ONE);
        //When
        SimpleRate testRate = mapper.mapToSimpleRate(simpleRateDto);
        //Then
        assertEquals(simpleRateDto.getCoinId(), testRate.getCoinId());
        assertEquals(simpleRateDto.getCurrency(), testRate.getCoinId());
        assertEquals(simpleRateDto.getRate(), testRate.getRate());

    }
}