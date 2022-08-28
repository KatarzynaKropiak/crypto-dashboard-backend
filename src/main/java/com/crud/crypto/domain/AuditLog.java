package com.crud.crypto.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity(name = "auditLog")
public class AuditLog {
    @javax.persistence.Id
    @Id
    @NotNull
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    private Long id;

    private String action;
    LocalDateTime date;

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public AuditLog(String action, LocalDateTime date) {
        this.action = action;
        this.date = date;
    }
}
