package com.crud.crypto.controller;

import com.crud.crypto.domain.SimpleRateDto;
import com.crud.crypto.domain.Wallet;
import com.crud.crypto.domain.WalletDto;
import com.crud.crypto.exception.WalletNotFoundException;
import com.crud.crypto.facade.CryptoFacade;
import com.crud.crypto.facade.WalletFacade;
import com.crud.crypto.mapper.AssetMapper;
import com.crud.crypto.mapper.WalletMapper;
import com.crud.crypto.repository.service.AssetDbService;
import com.crud.crypto.repository.service.AuditDbService;
import com.crud.crypto.repository.service.WalletDbService;
import com.google.gson.Gson;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringJUnitWebConfig
@WebMvcTest(WalletController.class)
@AutoConfigureMockMvc
class WalletControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private WalletDbService walletDbService;
    @MockBean
    private WalletMapper walletMapper;
    @MockBean
    private AssetDbService assetDbService;
    @MockBean
    private AssetMapper assetMapper;
    @MockBean
    private WalletFacade walletFacade;
    @MockBean
    private AuditDbService auditDbService;

    @Test
    void getWallets() throws Exception {
        //Given
        List<WalletDto> walletDtoList = List.of(new WalletDto(1L, "user", "email"));
        List<Wallet> walletList = List.of(new Wallet(1L, "user", "email"));

        when(walletMapper.mapToWalletDtoList(walletList)).thenReturn(walletDtoList);
        when(walletDbService.getAllWallets()).thenReturn(walletList);
        // When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/v1/crypto/wallets")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].email", Matchers.is("email")))
                .andDo(print());
    }

    @Test
    void getWallet() throws Exception {
        //Given
        WalletDto walletDto = new WalletDto(1L, "user", "email");
        Wallet wallet = new Wallet(1L, "user", "email");
        when(walletDbService.getWalletById(1L)).thenReturn(wallet);
        when(walletMapper.mapToWalletDto(wallet)).thenReturn((walletDto));

        // When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/v1/crypto/wallets/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$.email", Matchers.is("email")));
    }


    @Test
    void deleteWallet() throws Exception {
        //Given
        doNothing().when(walletDbService).deleteWallet(1L);

        // When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/v1/crypto/wallets/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200));
    }


    @Test
    void deleteAllWallets() throws Exception {
        //Given
        doNothing().when(walletDbService).deleteAllWallets();

        // When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/v1/crypto/wallets/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200));
    }

    @Test
    void updateWallet() throws Exception {
        //Given
        WalletDto walletDto = new WalletDto(1L, "user", "email");
        Wallet wallet = new Wallet(1L, "user", "email");
        Wallet updatedWallet = new Wallet(1L, "newUser", "newEmail");
        when(walletMapper.mapToWallet(walletDto)).thenReturn(wallet);
        when(walletDbService.saveWallet(wallet)).thenReturn(updatedWallet);
        when(walletMapper.mapToWalletDto(updatedWallet)).thenReturn(
                new WalletDto(1L, "newUser", "newEmail"));
        Gson gson = new Gson();
        String jsonContent = gson.toJson(updatedWallet);
        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/v1/crypto/wallets/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                        .content(jsonContent))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andDo(print());
    }

    @Test
    void createWallet() throws Exception {
        //Given
        WalletDto walletDto = new WalletDto(1L, "user", "email");
        Wallet wallet = new Wallet(1L, "user", "email");
        when(walletMapper.mapToWallet(walletDto)).thenReturn(wallet);
        when(walletDbService.saveWallet(wallet)).thenReturn(wallet);
        Gson gson = new Gson();
        String jsonContent = gson.toJson(wallet);
        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/v1/crypto/wallets")
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                        .content(jsonContent))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andDo(print());
    }

    @Test
    void deleteAsset() throws Exception {
        //Given
        doNothing().when(assetDbService).deleteAsset(1L);

        // When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/v1/crypto/assets/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200));
    }
}