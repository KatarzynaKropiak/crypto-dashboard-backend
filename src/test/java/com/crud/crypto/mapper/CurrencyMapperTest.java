package com.crud.crypto.mapper;

import com.crud.crypto.domain.Currency;
import com.crud.crypto.domain.CurrencyDto;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CurrencyMapperTest {

    private CurrencyMapper mapper = new CurrencyMapper();


    @Test
    void mapToCurrencyDto() {
        //Given
        Currency currency = new Currency("id", "name");
        //When
        CurrencyDto testCurrencyDto = mapper.mapToCurrencyDto(currency);
        //Then
        assertEquals(currency.getId(), testCurrencyDto.getId());
        assertEquals(currency.getName(), testCurrencyDto.getName());
    }

    @Test
    void mapToCurrency() {
        //Given
        CurrencyDto currencyDto = new CurrencyDto("id", "name");
        //When
        Currency testCurrency = mapper.mapToCurrency(currencyDto);
        //Then
        assertEquals(currencyDto.getId(), testCurrency.getId());
        assertEquals(currencyDto.getName(), testCurrency.getName());
    }

    @Test
    void mapToCurrencyDtoList() {
        //Given
        List<Currency> currencyList = new ArrayList<>();
        Currency currency = new Currency("id", "name");
        currencyList.add(currency);
        //When
        List<CurrencyDto> currencyDtos = mapper.mapToCurrencyDtoList(currencyList);
        //Then
        assertEquals(currencyList.get(0).getId(), currencyDtos.get(0).getId());
        assertEquals(currencyList.get(0).getName(), currencyDtos.get(0).getName());
    }

    @Test
    void mapToCurrencyList() {
        //Given
        List<CurrencyDto> currencyDtoList = new ArrayList<>();
        CurrencyDto currencyDto = new CurrencyDto("id", "name");
        currencyDtoList.add(currencyDto);
        //When
        List<Currency> currencies = mapper.mapToCurrencyList(currencyDtoList);
        //Then
        assertEquals(currencyDtoList.get(0).getId(), currencies.get(0).getId());
        assertEquals(currencyDtoList.get(0).getName(), currencies.get(0).getName());
    }
    }

