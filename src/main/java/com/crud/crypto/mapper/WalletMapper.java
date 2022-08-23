package com.crud.crypto.mapper;

import com.crud.crypto.domain.Wallet;
import com.crud.crypto.domain.WalletDto;
import lombok.Data;
import org.springframework.stereotype.Service;

@Data
@Service
public class WalletMapper {

        public WalletDto mapToWalletDto(final Wallet wallet) {
            return new WalletDto(
                    wallet.getUserId(),
                    wallet.getName(),
                    wallet.getEmail()
            );
        }

        public Wallet mapToWallet(final WalletDto walletDto) {
            return new Wallet(
                    walletDto.getUserId(),
                    walletDto.getName(),
                    walletDto.getEmail()
            );
        }

}
