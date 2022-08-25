package com.crud.crypto.mapper;

import com.crud.crypto.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CryptoMapper {

    public SimpleRateDto mapToSimpleRateDto(final SimpleRate simpleRate) {
        return new SimpleRateDto(
                simpleRate.getCoinId(),
                simpleRate.getCurrency(),
                simpleRate.getRate()
        );
    }
    public SimpleRate mapToSimpleRate(final SimpleRateDto simpleRateDto) {
        return new SimpleRate(
                simpleRateDto.getCoinId(),
                simpleRateDto.getCurrency(),
                simpleRateDto.getRate()
        );
    }

    public List<SimpleRateDto> mapToSimpleRateDtoList(final List<SimpleRate> simpleRateList) {
        return simpleRateList.stream()
                .map(this::mapToSimpleRateDto)
                .collect(Collectors.toList());
    }

    public List<SimpleRate> mapToSimpleRateList(final List<SimpleRateDto> simpleRateDtoList) {
        return simpleRateDtoList.stream()
                .map(this::mapToSimpleRate)
                .collect(Collectors.toList());
    }
}
