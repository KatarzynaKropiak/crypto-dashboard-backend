package com.crud.crypto;

import com.crud.crypto.client.CryptoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class CryptoApplication {



	public static void main(String[] args) {
		SpringApplication.run(CryptoApplication.class, args);



	}

}
