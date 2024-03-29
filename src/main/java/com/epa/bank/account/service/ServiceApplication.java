package com.epa.bank.account.service;

import com.google.gson.Gson;
import com.rabbitmq.client.Connection;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class ServiceApplication {

	@Autowired
	private Mono<Connection> connectionMono;

	@Bean
	public Gson createGson(){
		return new Gson();
	}

	public static void main(String[] args) {
		SpringApplication.run(ServiceApplication.class, args);
	}

	@PreDestroy
	public void close() throws Exception {
		connectionMono.block().close();
	}
}
