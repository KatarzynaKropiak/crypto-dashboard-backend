package com.crud.crypto.mapper;

import com.crud.crypto.domain.Wallet;
import com.crud.crypto.domain.WalletDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WalletMapper {

        public WalletDto mapToWalletDto(final Wallet wallet) {
            return new WalletDto(
                    wallet.getWalletId(),
                    wallet.getUserName(),
                    wallet.getEmail()
            );
        }

        public Wallet mapToWallet(final WalletDto walletDto) {
            return new Wallet(
                    walletDto.getWalletId(),
                    walletDto.getUserName(),
                    walletDto.getEmail()
            );
        }

    public List<WalletDto> mapToWalletDtoList(final List<Wallet> walletList) {
        return walletList.stream()
                .map(this::mapToWalletDto)
                .collect(Collectors.toList());
    }

    public List<Wallet> mapToWalletList(final List<WalletDto> walletDtoList) {
        return walletDtoList.stream()
                .map(this::mapToWallet)
                .collect(Collectors.toList());
    }

}
