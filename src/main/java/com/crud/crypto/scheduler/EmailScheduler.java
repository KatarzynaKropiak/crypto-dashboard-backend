package com.crud.crypto.scheduler;

import com.crud.crypto.config.AdminConfig;
import com.crud.crypto.domain.Mail;
import com.crud.crypto.repository.AssetRepository;
import com.crud.crypto.repository.WalletRepository;
import com.crud.crypto.repository.service.SimpleEmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class EmailScheduler {


    private final SimpleEmailService simpleEmailService;
    private final WalletRepository walletRepository;
    private final AdminConfig adminConfig;

    private static final String SUBJECT = "CryptoDashBoard: Once a day email";


    @Scheduled(cron = "0 0 10 * * *")
    public void sendInformationEmail() {
        int size = walletRepository.findAll().stream()
                .filter(wallet -> adminConfig.getAdminMail().equals(wallet.getEmail()))
                .collect(Collectors.toList()).size();
        String singularOrPlural;
        if (size == 1L) {
            singularOrPlural = " wallet";
        } else {
            singularOrPlural = " wallets";
        simpleEmailService.send(
                Mail.builder()
                        .mailTo(adminConfig.getAdminMail())
                        .subject(SUBJECT)
                        .message("Currently you've got: " + size + singularOrPlural)
                        .build()
        );
    }

    }
}
