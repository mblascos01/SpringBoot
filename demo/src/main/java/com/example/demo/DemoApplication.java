package com.example.demo;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

        // DEFINICIÓN DEL BEAN
        @Bean
        public RestClient.Builder restClientBuilder() {
            return RestClient.builder();
            // Spring guarda este objeto y lo reutiliza
        }

        // USO DEL BEAN (inyección automática)
        @Bean
        public ApplicationRunner runner(RestClient.Builder builder) {
            // ⬆️ Spring inyecta automáticamente el Builder
            return args -> {
                RestClient client = builder
                        .baseUrl("http://localhost:8080")
                        .build();
            };
        }
		SpringApplication.run(DemoApplication.class, args);
	}

}
