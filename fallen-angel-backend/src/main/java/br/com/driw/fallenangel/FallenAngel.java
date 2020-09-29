package br.com.driw.fallenangel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableFeignClients
@EnableJpaRepositories
public class FallenAngel {

	public static void main(String[] args) {
		SpringApplication.run(FallenAngel.class, args);
	}

}
