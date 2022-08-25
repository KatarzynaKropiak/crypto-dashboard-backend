package com.crud.crypto.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Mail {
    private final String mailTo;
    private final String subject;
    private final String message;
}