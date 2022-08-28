package com.crud.crypto.mapper;

import com.crud.crypto.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SimpleRateMapper {

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

}
