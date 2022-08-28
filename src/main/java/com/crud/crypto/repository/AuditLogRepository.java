package com.crud.crypto.repository;

import com.crud.crypto.domain.AuditLog;
import org.springframework.data.repository.CrudRepository;

public interface AuditLogRepository extends CrudRepository<AuditLog, Long> {

    @Override
    AuditLog save(AuditLog auditLog);



}
