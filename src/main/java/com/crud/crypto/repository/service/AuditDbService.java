package com.crud.crypto.repository.service;

import com.crud.crypto.domain.AuditLog;
import com.crud.crypto.repository.AuditLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuditDbService {

    @Autowired
    AuditLogRepository repository;

    public AuditLog savelog(AuditLog auditLog) {
        return repository.save(auditLog);

    }

}
