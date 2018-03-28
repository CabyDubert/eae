package me.eae.upms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class EaeUpmsWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(EaeUpmsWebApplication.class, args);
	}
}
