package br.com.radiflix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
@ComponentScan({ 
	"com.itau.latam.config", 
	"com.itau.latam.msghandler.controller", 
	"com.itau.latam.msghandler.service"
})
public class MediaHubApplication {

	public static void main(String[] args) {
		SpringApplication.run(MediaHubApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
}
