package com.crud.crypto.repository;

import com.crud.crypto.domain.Mail;
import org.springframework.data.repository.CrudRepository;

public interface EmailRepository extends CrudRepository <Mail, Long> {

    @Override
    Mail save (Mail mail);
}
