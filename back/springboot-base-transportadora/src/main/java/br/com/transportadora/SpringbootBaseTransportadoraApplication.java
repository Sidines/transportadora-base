package br.com.transportadora;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"br.com.transportadora.model"})
public class SpringbootBaseTransportadoraApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootBaseTransportadoraApplication.class, args);
	}

}
