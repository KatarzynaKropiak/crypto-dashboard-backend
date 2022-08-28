package com.crud.crypto.config;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdminConfigTest {

    @Test
    void shouldNotShowInformation() {
        //Given
        AdminConfig adminConfig = new AdminConfig();
        //When
        String result = adminConfig.getAdminMail();
        //Then
        assertNull(result);

    }
}