package com.crud.crypto.mapper;

import com.crud.crypto.domain.Currency;
import com.crud.crypto.domain.CurrencyDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CurrencyMapper {
    public CurrencyDto mapToCurrencyDto(final Currency currency) {
        return new CurrencyDto(
                currency.getId(),
                currency.getName()
        );
    }

    public Currency mapToCurrency(final CurrencyDto currencyDto) {
        return new Currency(
                currencyDto.getId(),
                currencyDto.getName()
        );
    }

    public List<CurrencyDto> mapToCurrencyDtoList(final List<Currency> currencyList) {
        return currencyList.stream()
                .map(this::mapToCurrencyDto)
                .collect(Collectors.toList());
    }
}