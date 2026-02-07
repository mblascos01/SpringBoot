package com.consumoRest.consumoRest;

import com.consumoRest.consumoRest.Modelos.Quote;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.web.client.RestClient;

@SpringBootApplication
public class ConsumoRestApplication {

	private static final Logger log = LoggerFactory.getLogger(ConsumoRestApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ConsumoRestApplication.class, args);
	}

	@Bean
	@Profile("!test")
	public ApplicationRunner run(RestClient.Builder builder) {
		RestClient restClient = builder.baseUrl("http://localhost:8080").build();
		return args -> {
			Quote quote = restClient
					.get().uri("/api/random")
					.retrieve()
					.body(Quote.class);
			log.info(quote.toString());
		};
	}
}